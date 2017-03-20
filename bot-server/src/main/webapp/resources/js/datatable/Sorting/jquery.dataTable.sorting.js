$.extend(jQuery.fn.dataTableExt.oSort, {
	"date-uk-pre" : function(a) {
		var x;
		try {
			var dateA = a.replace(/ /g, '').split("/");
			var day = parseInt(dateA[0], 10);
			var month = parseInt(dateA[1], 10);
			var year = parseInt(dateA[2], 10);
			var date = new Date(year, month - 1, day)
			x = date.getTime();
		} catch (err) {
			x = new Date().getTime();
		}

		return x;
	},

	"date-uk-asc" : function(a, b) {
		return a - b;
	},

	"date-uk-desc" : function(a, b) {
		return b - a;
	}
});