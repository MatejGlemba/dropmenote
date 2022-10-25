app.controller("DForgotPasswordEmailSendController", function ($rootScope, $scope, $http, $cookies, $mdDialog, dpnService, dpnToast,$mdToast, paramEmail, dpnDialog) {

    // init data
    $scope.email = '';

    if (paramEmail) {
        $scope.email = paramEmail;
    }
    //-------------------------
    // Click events
    //-------------------------

    // reset password for user
    $scope.sendEmail = function() {
        if (!$scope.email) {
            dpnToast.showToast("ERROR", "Empty email", "Fill in email");
            return;
        }
        var call_user_forgotPasswordCallBackSuccess = function(data) {
            dpnDialog.showLogin($scope.email);
            dpnToast.showToast("INFO", "Email sent", "Email successfully sent");
        }
        var call_user_forgotPasswordCallBackError = function(data) {        
            dpnDialog.showLogin($scope.email);  
            dpnToast.showToast("ERROR", "Email error", "Email not sent!");
        }
        dpnService.call_user_forgotPassword($scope.email, call_user_forgotPasswordCallBackSuccess, call_user_forgotPasswordCallBackError);
    }

    $scope.closeDialog = function() {
        dpnDialog.showLogin($scope.email);
    }
});