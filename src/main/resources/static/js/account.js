var module = angular.module('bank', []);


module.service('AccountService', function ($http) {

    this.accounts = function ($scope, $http) {

        console.log("i am in service function")

        $http.get('/banking/accounts/').success(function (data) {
            console.log(data);
            $scope.accounts = data;
        })
    }


});


module.service('TransactionService', function ($http) {

    this.transactions = function ($scope, $http) {

        console.log("i am in transactions service")

        $http.get('/banking/transactions/').success(function (data) {
            console.log(data);
            $scope.transactions = data;
        })
    }

});

module.controller('accounts', function ($scope, $http, AccountService, TransactionService) {


    //initial load
    $http.get('/banking/accounts/').success(function (data) {

        $scope.accounts = data;

        console.log(data)

    })

    //initial load
    $http.get('/banking/transactions/').success(function (data) {

        $scope.transactions = data;

        console.log(data)

    })



    $scope.getAccounts = function () {

        console.log('I am in getAccounts')
        $scope.accounts = AccountService.accounts($scope, $http);
    }


    $scope.getTransactions = function () {

        console.log('I am in getTransactions')
        $scope.accounts = TransactionService.transactions($scope, $http);
    }


});




