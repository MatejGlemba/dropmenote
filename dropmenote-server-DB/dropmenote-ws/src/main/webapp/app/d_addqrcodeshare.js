app.controller("DAddQrCodeShareController", function ($rootScope, $scope, $http, $cookies, dpnService, dpnToast, $mdDialog, dpnDialog, param_parent, param_qrcode_id) {
    
    $scope.serviceCalled = false;
    // ----------------
    // load data
    // ---------------
    $scope.qrCodeId = "";
    $scope.shareUserLogin = "";
    
    if(param_qrcode_id != undefined) {
        $scope.qrCodeId = param_qrcode_id;
    }

    // ------------
    // Click events
    // ------------
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    $scope.click_qrcodeshare_add = function() {
        if ($scope.serviceCalled) {
            dpnToast.showToast("INFO", "Adding share user", "Please wait");
            return;
        }
        $scope.serviceCalled = true;
        var call_qrcodeshare_add_callBackSuccess = function() {
            $mdDialog.hide();
            dpnToast.showToast('INFO', 'DMN share saved', 'DMN Code shared successfully');
            
            // Reload parent
            param_parent.init();
            $scope.serviceCalled = false;
        }
        var call_qrcodeshare_add_callBackError = function(data) {
            dpnService.processErrorResponse(data);
            $scope.serviceCalled = false;
        }
        dpnService.call_qrcode_addShare($scope.qrCodeId, $scope.shareUserLogin, call_qrcodeshare_add_callBackSuccess, call_qrcodeshare_add_callBackError);
    }
});