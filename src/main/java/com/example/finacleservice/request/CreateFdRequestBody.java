package com.example.finacleservice.request;

import java.util.List;


public record CreateFdRequestBody(RequestBody requestBody) {
    public static class CreateFdRequestBodyBuilder {
        private RequestBody requestBody;

        public static CreateFdRequestBodyBuilder builder() {
            return new CreateFdRequestBodyBuilder();
        }

        public CreateFdRequestBodyBuilder withRequestBody(RequestBody requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public CreateFdRequestBody build() {
            return new CreateFdRequestBody(requestBody);
        }
    }


    public record RequestBody(

            CustomerDetails customerDetails,
            TDAccountDetails tdAccountDetails,
            TDAccountGeneralInfo tdAccountGeneralInfo,
            InitialDeposit initialDeposit,
            DepositTerm depositTerm,
            RepaymentAccountDetails repaymentAccountDetails,
            RenewalDetails renewalDetails,
            DebitTransactionDetails debitTransactionDetails,
            List<NomineeDetails> nomineeDetails
    ) {
        public record CustomerDetails(
                String customerId
        ) {
        }

        public record TDAccountDetails(
                AccountType accountType,
                String currency,
                BankDetails bankDetails
        ) {
            public record AccountType(
                    String schemeCode
            ) {
            }

            public record BankDetails(
                    String branchId
            ) {
            }
        }

        public record TDAccountGeneralInfo(
                String accountStatementMode
        ) {
        }

        public record InitialDeposit(
                String amount,
                String currencyCode
        ) {
        }

        public record DepositTerm(
                int days,
                int months
        ) {
        }

        public record RenewalTerm(
                int days,
                int months
        ) {
        }


        public record RepaymentAccountDetails(
                String accountId
        ) {
        }

        public record RenewalDetails(
                String autoCloseOnMaturityFlag,
                String autoRenewalFlag,
                RenewalTerm renewalTerm
        ) {
        }

        public record DebitTransactionDetails(
                String transactionType,
                String transactionSubType,
                DebitAccountDetails debitAccountDetails
        ) {
            public record DebitAccountDetails(
                    String accountId
            ) {
            }
        }
    }

    public static class RequestBodyBuilder {
        private RequestBody.CustomerDetails customerDetails;
        private RequestBody.TDAccountDetails tdAccountDetails;
        private RequestBody.TDAccountGeneralInfo tdAccountGeneralInfo;
        private RequestBody.InitialDeposit initialDeposit;
        private RequestBody.DepositTerm depositTerm;
        private RequestBody.RepaymentAccountDetails repaymentAccountDetails;
        private RequestBody.RenewalDetails renewalDetails;
        private RequestBody.DebitTransactionDetails debitTransactionDetails;
        private List<NomineeDetails> nomineeDetails;

        public static RequestBodyBuilder builder() {
            return new RequestBodyBuilder();
        }

        public RequestBodyBuilder withCustomerDetails(RequestBody.CustomerDetails customerDetails) {
            this.customerDetails = customerDetails;
            return this;
        }

        public RequestBodyBuilder withTdAccountDetails(RequestBody.TDAccountDetails tdAccountDetails) {
            this.tdAccountDetails = tdAccountDetails;
            return this;
        }

        public RequestBodyBuilder withTdAccountGeneralInfo(RequestBody.TDAccountGeneralInfo tdAccountGeneralInfo) {
            this.tdAccountGeneralInfo = tdAccountGeneralInfo;
            return this;
        }

        public RequestBodyBuilder withInitialDeposit(RequestBody.InitialDeposit initialDeposit) {
            this.initialDeposit = initialDeposit;
            return this;
        }

        public RequestBodyBuilder withDepositTerm(RequestBody.DepositTerm depositTerm) {
            this.depositTerm = depositTerm;
            return this;
        }

        public RequestBodyBuilder withRepaymentAccountDetails(RequestBody.RepaymentAccountDetails repaymentAccountDetails) {
            this.repaymentAccountDetails = repaymentAccountDetails;
            return this;
        }

        public RequestBodyBuilder withRenewalDetails(RequestBody.RenewalDetails renewalDetails) {
            this.renewalDetails = renewalDetails;
            return this;
        }

        public RequestBodyBuilder withDebitTransactionDetails(RequestBody.DebitTransactionDetails debitTransactionDetails) {
            this.debitTransactionDetails = debitTransactionDetails;
            return this;
        }

        public RequestBodyBuilder withNomineeDetails(List<NomineeDetails> nomineeDetails) {
            this.nomineeDetails = nomineeDetails;
            return this;
        }

        public RequestBody build() {
            return new RequestBody(
                    customerDetails,
                    tdAccountDetails,
                    tdAccountGeneralInfo,
                    initialDeposit,
                    depositTerm,
                    repaymentAccountDetails,
                    renewalDetails,
                    debitTransactionDetails,
                    nomineeDetails
            );
        }
    }

}

