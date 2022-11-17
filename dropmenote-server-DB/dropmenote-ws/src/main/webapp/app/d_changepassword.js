app.controller("DChangePasswordController", function ($rootScope, $scope, $http, $cookies, $mdDialog, paramLogin, dpnService, dpnToast) {

    // init data
    $scope.changepassword = {
        login: paramLogin,
        password: '',
        repeatpassword: '',
    };
   
    //-------------------------
    // Click events
    //-------------------------
    // check if passwords are same, otherwise display error-msg
    var repeatpasswordValidate = function (form) {
        if ($scope.changepassword.password != $scope.changepassword.repeatpassword) {
            form.changepassword_repeatpassword.$setValidity('passwordMismatch', false);
        } else {
            form.changepassword_repeatpassword.$setValidity('passwordMismatch', true);
        }
    };

    // call ws/user/updatepassword service
    $scope.click_changepasswordService = function() {

        // validate
        if (isBlank($scope.changepassword.password) || $scope.changepassword.password == null || $scope.changepassword.password == undefined 
                || $scope.changepassword.password != $scope.changepassword.repeatpassword) {
            dpnToast.showToast("ERROR", "Password error!", "Passwords must match!");
            return;
        }

        // callbacks
        var click_changepasswordService_callbackSuccess = function () {
            $scope.closeDialog();
            dpnToast.showToast("INFO", "Password changed", "Password changed successfully");
        };
        var click_changepasswordService_callbackError = function (data) {
            $scope.closeDialog();
            dpnService.processErrorResponse(data);
        };  
        // call webservice
        dpnService.call_user_updatePassword($scope.changepassword.password, click_changepasswordService_callbackSuccess, click_changepasswordService_callbackError);
    }   

    // hide dialog
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }
});