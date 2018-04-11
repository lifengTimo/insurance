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
        },
        onClick:function (node) {
            console.log(node.text+node.url);
            if(node.url){
                if($('#tabs').tabs('exists',node.text)){
                    $('#tabs').tabs('select',node.text);
                }else{
                    $('#tabs').tabs('add',{
                        title:node.text,
                        iconCls:node.iconCls,
                        closable:true,
                        href:node.url,
                    });
                }

            }
        }
	});

	$('#tabs').tabs({
		fit:true,
		border:false,
	});
});