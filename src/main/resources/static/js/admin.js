$(function(){
	$('#nav').tree({
		url:'/nav/getAll',
		lines:true,
		onLoadSuccess:function (node, data) {
			if(data){
				$(data).each(function (index,value) {
					if(this.state='closed'){
                        $('#nav').tree('expandAll');
					}
                });
			}
        }
	});

	$('#tabs').tabs({
		fit:true,
		border:false,
	});
});