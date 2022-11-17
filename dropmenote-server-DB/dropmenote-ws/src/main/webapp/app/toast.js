app.service("dpnToast", ['$mdToast', function ( $mdToast ) {

    // Toast type values enum
    // ERROR
    // INFO
    // MESSAGE

    this.showToast = function(toastType, toastMessage, toastDescription, toastData) {
        $mdToast.show({
            hideDelay   : 5000,
            position    : 'bottom center',
            controller  : 'ToastCtrl',
            templateUrl : 'toast.html',
            locals:{
                toastType: toastType,
                toastMessage: toastMessage,
                toastDescription: toastDescription,
                toastData: toastData
            } 
        })
    };
}]);


app.controller('ToastCtrl', ['$scope', 'toastType', 'toastMessage', 'toastDescription', 'toastData', '$mdToast', function ($scope, toastType, toastMessage, toastDescription, toastData, $mdToast) {
    $scope.toastType = toastType;
    $scope.toastMessage = toastMessage;
    $scope.toastDescription = toastDescription;
    $scope.toastData = toastData;

    if($scope.toastType == 'ERROR'){
        $scope.toastCss = "ng-scope md-top md-center md-toast-error";
    }else if($scope.toastType == 'INFO'){
        $scope.toastCss = "ng-scope md-top md-center md-toast-info";
    }else if($scope.toastType == 'MESSAGE'){
        $scope.toastCss = "ng-scope md-top md-center md-toast-message";
    }

    $scope.chatParams;
    if ($scope.toastType == 'MESSAGE' && $scope.toastData && $scope.toastData.roomId != undefined && $scope.toastData.qr != undefined) {
        $scope.chatParams = "?qr=" + $scope.toastData.qr + "&roomId=" + $scope.toastData.roomId;
    }

    $scope.click_chat = function() {
        if ($scope.chatParams != undefined) {
            window.open("#/chat" + $scope.chatParams, "_self");
        }
    }

    $scope.click_hideToast = function() {
        if ($scope.toastType == 'INFO' || $scope.toastType == 'ERROR') {
            $mdToast.hide();
        }
    }
}]);