app.controller("DInboxFilterController", function ($rootScope, $scope, $http, $cookies, $mdDialog, dpnService, dpnToast, dpnDialog) {

    // init data
    $scope.qrcodelist = [];
    $scope.orderByParam = "id";
    $scope.orderByReverse = false;

    //----------
    // load data
    //----------

    // callbacks
    var call_qrcode_loadAllForInbox_callBackSuccess = function (data) {
        $scope.qrcodelist = data;
    }
    var call_qrcode_loadAllForInbox_callBackError = function (data) {
        dpnService.processErrorResponse(data);
    }

    // call webservice
    dpnService.call_qrcode_loadAllForInbox(call_qrcode_loadAllForInbox_callBackSuccess, call_qrcode_loadAllForInbox_callBackError);
   
    //-------------------------
    // Click events
    //-------------------------

    // hide dialog
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    // click order by id,name,alias,... button
    $scope.click_orderBy = function(orderByParam) {
        if (orderByParam != undefined || orderByParam != null || orderByParam != "") {
            $scope.orderByReverse = ($scope.orderByParam === orderByParam) ? !$scope.orderByReverse : false;
            $scope.orderByParam = orderByParam;
        }        
    }

    // on click qr code open inbox with id as parameter in url
    $scope.click_on_qrcode = function(qrcode) {
        $mdDialog.hide();
    }
});