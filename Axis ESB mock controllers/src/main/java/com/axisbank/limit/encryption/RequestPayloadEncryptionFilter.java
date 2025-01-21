package com.axisbank.limit.encryption;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.axisbank.limit.constants.AxisMessageStatusCodes;
import com.axisbank.limit.exception.AxisException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestPayloadEncryptionFilter extends OncePerRequestFilter {

	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;

	@Autowired
	private AESEncryptionUtil aesEncryptionUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		CustomHttpServletRequestWrapper requestWrapper = null;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String isEncrypted = httpServletRequest.getHeader("enc");
		/*httpServletRequest.getHeaderNames().asIterator().forEachRemaining(name->{
			System.out.print("Name :"+name);
			System.out.println("       Value :"+httpServletRequest.getHeader(name));
		});*/
		String esbChannel = httpServletRequest.getHeader("channelid");

		//logger.info("******* request intercepted ***********");
		if (StringUtils.isNotBlank(isEncrypted) && ("Yes").equalsIgnoreCase(isEncrypted)) {
			String channel = httpServletRequest.getHeader("channel");
			String inputData = IOUtils.toString(request.getInputStream(), "UTF-8");
			if (StringUtils.isNotBlank(inputData)) {
				inputData = inputData.replaceAll("^\"|\"$", "");
				boolean isBase64 = Base64.isBase64(inputData.getBytes());
				if (isBase64) {
					String decryptedData = aesEncryptionUtil.decrypt(inputData, channel);
					if (StringUtils.isNotBlank(decryptedData)) {
						byte[] decryptedString = decryptedData.getBytes();
						if (decryptedString == null) {
							filterChain.doFilter(request, response);
						}
						requestWrapper = new CustomHttpServletRequestWrapper(request, decryptedString);
					} else {
						resolver.resolveException(request, response, null,
								new AxisException(AxisMessageStatusCodes.E100.name()));
					}
				}
			}
			httpServletResponse.setHeader("isEcrypted", "true");
			httpServletResponse.setHeader("channel", channel);
		} /*if (StringUtils.isNotBlank(esbChannel) && ("DCOM1").equalsIgnoreCase(esbChannel)) {
			System.out.println("************ INSIDE ESB BLOCK  *************");
			String inputData = IOUtils.toString(request.getInputStream(), "UTF-8");
			if (StringUtils.isNotBlank(inputData)) {
				inputData = inputData.replaceAll("^\"|\"$", "");
				boolean isBase64 = Base64.isBase64(inputData.getBytes());
				if (isBase64) {
					String decryptedData = ESBAES128Encryption.decrypt(inputData, "DCOM0v987c7b2098fg022e908l4400x0300e000");
					if (StringUtils.isNotBlank(decryptedData)) {
						byte[] decryptedString = decryptedData.getBytes();
						if (decryptedString == null) {
							filterChain.doFilter(request, response);
						}
						requestWrapper = new CustomHttpServletRequestWrapper(request, decryptedString);
					} else {
						resolver.resolveException(request, response, null,
								new AxisException(AxisMessageStatusCodes.E100.name()));
					}
				}
			}
		}*/

		if (requestWrapper != null) {
			filterChain.doFilter(requestWrapper, httpServletResponse);
		} else {
			filterChain.doFilter(request, response);
		}

	}

}