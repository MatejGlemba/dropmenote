app.controller("DEditQrCodeShareController", function ($rootScope, $scope, $http, $cookies, $mdDialog, param_parent, param_qrcode_id ,param_qrshareObject, dpnService, dpnDialog, dpnToast) {

    $scope.serviceCalled = false;
    // --------------
    // load data
    // --------------
    $scope.qrCodeId = "";
    $scope.shareUserLogin = "";
    
    if(param_qrshareObject != undefined){
        $scope.shareUserLogin = param_qrshareObject;
    }
    if(param_qrcode_id != undefined) {
        $scope.qrCodeId = param_qrcode_id;
    }

    // ------------
    // Click events
    // ------------
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    $scope.click_qrcodeshare_delete = function() {
        if ($scope.serviceCalled) {
            dpnToast.showToast("INFO", "Removing shared user", "Please wait");
            return;
        }
        $scope.serviceCalled = true;
        var call_qrcodeshare_delete_callBackSuccess = function() {
            $mdDialog.hide();
            dpnToast.showToast('INFO', 'User removed', 'User was successfully removed from DMN Share list');
            
            // Reload parent
            param_parent.init();
            $scope.serviceCalled = false;
        }
        var call_qrcodeshare_delete_callBackError = function(data) {
            dpnService.processErrorResponse(data);
            $scope.serviceCalled = false;
        }
        dpnService.call_qrcode_removeShare($scope.qrCodeId, $scope.shareUserLogin, call_qrcodeshare_delete_callBackSuccess, call_qrcodeshare_delete_callBackError);
    }
});