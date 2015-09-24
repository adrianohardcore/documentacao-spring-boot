//clienteapp.js
var app = angular.module('app', ['ngResource','notifications']);

//--------------------
app.filter('paging', ["SharedObject", function(SharedObject) {
	return function(input, pSize) {
		SharedObject.recordsCount = (input && input.length) ? input.length : 0;
		if(input){
			var size = parseInt(pSize, 10),
				pageNum = SharedObject.pageNum;
			if (input.length <= size)
				return input;
			var items = [];
			for (var i = 0; i < input.length; i++) {
				if (i < size * (pageNum - 1)) continue;
				if (i >= size * (pageNum - 1) + size) break;
				else items.push(input[i]);
			}
			return items;
		} else return null;
	}
}]);

//--------------------
app.factory("SharedObject", function() {
	return {
		recordsCount: 0,
		editItemNumber: 0,
		pageNum: 1,
		insertMode: false,
		reset: function() {
			//this.recordsCount=0;
			this.editItemNumber = 0;
			this.pageNum = 1;
			this.insertMode = false;
		}
	};
});
app.factory("HelperService", function() {
	return {
		GetErrorMessage: function(errObj){
			//console.log(errObj);
			if(errObj.status === 0)
				return "Error: unable to connect with server.";
			else if(errObj.data != "")
				return errObj.data;
			else{
				if(window.console)
					console.log(errObj);
				return "Error occured, check console for details.";
			}
		},
		RemoveItem: function(allItems, removeItem) {
			angular.forEach(allItems, function(item, i) {
				if (angular.equals(item, removeItem))
					allItems.splice(i, 1);
			});
		},
		Validate: function(type, value) {
			var isValid = true;
			switch (type) {
				case 'int':
					isValid = /^\d+$/.test(value);
					break;
				case 'float':
					isValid = /^\d+(.\d+?)$/.test(value);
					break;
				case 'string':
					isValid = /^[A-Z,a-z]+/.test(value);
					break;
				case 'date':
					var vals = value.split('-');
					isValid = vals.length === 3 && vals[1] < 13 && vals[2] < 32 && vals[0] < 2055;
					break;
				default:
					isValid = true;
					break;
			}
			return isValid;
		}
	};
});

app.factory('Cliente', ['$resource', function($resource) {
	return $resource('/clientes/:doctocliente', null,
	{
		'update': { method:'PUT' }
	});
}]);

//-----------------
// [ {id:10011, name:'ipad mini', price:1200, date:'2012-12-31', quantity:2},
// {id:10012, name:'ipad Air', price:2200, date:'2012-02-14', quantity:2},
// {id:10013, name:'Samsung Tab3', price:600, date:'2013-08-25', quantity:1},
// {id:10014, name:'LG G2', price:2500, date:'2011-03-30', quantity:3},
// {id:10015, name:'Lenovo pad', price:800, date:'2013-04-21', quantity:1},
// {id:10016, name:'Sony Xperia', price:1100, date:'2012-05-15', quantity:2},
// {id:10017, name:'Macromax', price:2300, date:'2011-11-19', quantity:3},
// {id:10018, name:'Nokia lumia', price:2900, date:'2013-07-23', quantity:5},
// {id:10019, name:'Dell laptop', price:850, date:'2013-01-20', quantity:1},
// {id:10020, name:'Mac pro', price:3500, date:'2012-09-29', quantity:2},
// {id:10021, name:'iberry nuclea', price:3000, date:'2011-12-26', quantity:5},
// {id:10022, name:'intex', price:180, date:'2010-09-10', quantity:1},
// {id:10023, name:'Videocon', price:2500, date:'2011-08-23', quantity:3},
// {id:10024, name:'Nexus 5', price:2800, date:'2012-06-01', quantity:4},
// {id:10025, name:'chrome Book', price:2000, date:'2013-05-04', quantity:3} ];
