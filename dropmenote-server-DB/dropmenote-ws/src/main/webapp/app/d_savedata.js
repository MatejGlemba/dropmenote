app.controller("DSaveDataController", function ($rootScope, $scope, $mdDialog, dpnToast, dpnService, paramObject, paramScreen, paramDestination) {

    $scope.requestObject = paramObject;
    $scope.screenName = paramScreen;
    $scope.destinationScreen = paramDestination;

    // ------------
    // Click events
    // ------------
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    $scope.save = function() {
        if ($scope.screenName == 'saveqrcode') {
            $scope.save_qrcode($scope.requestObject);
        }
        if ($scope.screenName == 'setting') {   
            $scope.save_setting($scope.requestObject);
        }
        $scope.closeDialog();
    }

    $scope.cancel = function() {
        $scope.closeDialog();
    }

    $scope.save_qrcode = function(qrcode) {
        // callbacks
        var click_saveqrcode_submit_callbackSuccess = function (data) {
            dpnToast.showToast("INFO", 'DMN Code save', 'Your data was saved');
        };
        var click_saveqrcode_submit_callbackError = function (data) {
            dpnService.processErrorResponse(data);
        };

        // validation 
        if (isBlank(qrcode.name)) {
            $scope.isProcessingSubmit = false;
            dpnToast.showToast("ERROR", 'Invalid input', 'Empty name!');
            return;
        }
        if (isBlank(qrcode.type)) {
            $scope.isProcessingSubmit = false;
            dpnToast.showToast("ERROR", 'Invalid input', 'Unselected type!');
            return;
        }
        if (isBlank(qrcode.ownerAlias)) {
            $scope.isProcessingSubmit = false;
            dpnToast.showToast("ERROR", 'Invalid input', 'Empty alias');
            return;
        }
        if (isBlank(qrcode.description)) {
            $scope.isProcessingSubmit = false;
            dpnToast.showToast("ERROR", 'Invalid input', 'Empty description!');
            return;
        }
        if (!isBlank(qrcode.photo) && qrcode.photo.includes("data:image/gif;base64")){
            $scope.isProcessingSubmit = false;
            dpnToast.showToast("ERROR", 'Invalid input', "App doesn't support .GIF!");
            return;
        }
        if (isBlank(qrcode.icon)) {
            $scope.isProcessingSubmit = false;
            dpnToast.showToast("ERROR", 'Invalid input', 'Unselected icon!');
            return;
        }

        // call webservice
        dpnService.call_qrcode_save(qrcode, click_saveqrcode_submit_callbackSuccess, click_saveqrcode_submit_callbackError);
    }

    $scope.save_setting = function(user) {
        // update user callbacks
        var click_saveuser_submit_callbackSuccess = function () {
            dpnToast.showToast("INFO", 'Settings saved', 'Your data was saved');
        };
        var click_saveuser_submit_callbackError = function (data) {
            dpnService.processErrorResponse(data);
        };

        // validations
        if (user.alias == null || user.alias == "") {
            dpnToast.showToast("ERROR", 'Invalid input', 'Alias is required field');
            return;
        }
        // if (user.password == null || user.password == "") { // password sa nemeni pri volani user update servisy
        //   alert('empty password');
        //   return;
        // }
        //if (user.photo == null || user.photo == "") {
        //    dpnToast.showToast("ERROR", 'Invalid input', 'Photo is required field');
        //    return;
        //}
        if (user.login == null || user.login == "") {
            dpnToast.showToast("INFO", 'Not logged in', 'Not logged in');
            return;
        }

        // call update user
        dpnService.call_user_update(user, click_saveuser_submit_callbackSuccess, click_saveuser_submit_callbackError);
    }
});