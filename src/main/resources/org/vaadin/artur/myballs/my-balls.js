org_vaadin_artur_myballs_MyBalls = function() {
	var self = this;
	var element = this.getElement();
	
	var ids = [ "red", "green", "blue" ];
	ids.forEach(function(id) {
		element.addEventListener(id + "-click", function() {
			self.onClick(id);
		});
	});
}

org_vaadin_artur_myballs_MyBalls.tag = "my-balls";