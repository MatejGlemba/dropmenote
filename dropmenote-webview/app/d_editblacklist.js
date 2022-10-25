app.controller("DBlacklistController", function ($rootScope, $scope, $http, $cookies, $mdDialog, param_parent, param_blacklistObject, param_showDelete, dpnService, dpnDialog, dpnToast) {

    // ----------------
    // load data
    // ---------------
    $scope.blacklistObject = {
        alias: "",
        note: "",
        uuid: ""
    };

    if(param_blacklistObject != undefined){
        $scope.blacklistObject = param_blacklistObject;
    }

    $scope.showDelete = param_showDelete;

    // ------------
    // Click events
    // ------------
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    // open forgotpassword dialog
    $scope.click_blacklist_delete = function(login) {
        var call_blacklist_removeFromBlacklist_callBackSuccess = function() {
            $mdDialog.hide();
            dpnToast.showToast('INFO', 'User allowed', 'User was removed from Blacklist');
            
            // Relaod parent
            param_parent.init();
        }
        var call_blacklist_removeFromBlacklist_callBackError = function() {
            dpnToast.showToast('ERROR', 'User not removed!', 'There was an error during removal');
        }

        dpnService.call_blacklist_removeFromBlacklist($scope.blacklistObject.uuid, call_blacklist_removeFromBlacklist_callBackSuccess, call_blacklist_removeFromBlacklist_callBackError);
    }

    $scope.click_blacklist_save = function() {
        var call_blacklist_addToBlacklist_callBackSuccess = function() {
            $mdDialog.hide();
            dpnToast.showToast('INFO', 'User blocked', 'User was successfully added to Blacklist');
            
            // Reload parent
            param_parent.init();
        }
        var call_blacklist_addToBlacklist_callBackError = function() {
            
        }

        dpnService.call_blacklist_addToBlacklist($scope.blacklistObject, call_blacklist_addToBlacklist_callBackSuccess, call_blacklist_addToBlacklist_callBackError);
    }

});