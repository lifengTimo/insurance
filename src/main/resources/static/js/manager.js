$(function(){
	$('#manager').datagrid({
        url:'/admin/getAllAdmin',
        fit:true,
        fitColumns:true,
        striped:true,
        rownumbers:true,
        border:false,
        pagination:true,
        pageSize:20,
        pageList:[10,20,30,40,50],
        pageNumber:1,
        sortName:'createTime',
        sortOder:'desc',
        toolbar:'#manager_tool',
        columns:[[
            {
                field:'id',
                title:'自动编号',
                width:100,
                checkbox:true,
            },
            {
                field:'userName',
                title:'管理员姓名',
                width:100,
            },

            {
                field:'createTime',
                title:'创建时间',
                width:100,
            },

        ]]
    });
	//操作员添加
    $('#manager_add').dialog({
        width: 350,
        title: '新增管理',
        iconCls:'icon-admin-add',
        modal:true,
        closed:true,
        buttons:[{
            text:'提交',
            iconCls:'icon-add',
            handler:function () {
                if($('#manager_add').form('validate')){
                        $.ajax({
                            url:'/admin/insertAdmin',
                            type:'post',
                            data:{
                                userName:$('input[name="manager"]').val(),
                                password:$('input[name="password"]').val(),
                                auth:$('#auth').combotree('getText'),
                            },
                            beforeSend:function () {
                                $.messager.progress({
                                    text:'正在新增中。。。',
                                });
                            },
                            success : function (data, response, status) {
                                $.messager.progress('close');
                                if(data>0){
                                    $.messager.show({
                                        title:'提示',
                                        msg:'新增管理成功',
                                    });
                                    $('#manager_add').dialog('close').form('reset');
                                    $('#manager').datagrid('reload');
                                }else{
                                    $.messager.alert('新增失败','未知错误导致！','warning');
                                }
                            }
                        });
                }
            },
        },{
            text:'取消',
            iconCls:'icon-redo',
            handler:function () {
                $('#manager_add').form('reset');
                $('#manager_add').dialog('close').close();
            },
        }]
    });
    //操作员修改
    $('#manager_edit').dialog({
        width: 350,
        title: '修改管理',
        iconCls:'icon-admin-add',
        modal:true,
        closed:true,
        buttons:[{
            text:'提交',
            iconCls:'icon-edit',
            handler:function () {
                if($('#manager_edit').form('validate')){
                    $.ajax({
                        url:'/admin/updateAdmin',
                        type:'post',
                        data:{
                            id:$('#id').val(),
                            password:$('input[name="password_edit"]').val(),
                            userName:$('input[name="manager_edit"]').val(),
                            auth:$('#auth_edit').combotree('getText'),
                        },
                        beforeSend:function () {
                            $.messager.progress({
                                text:'正在修改中。。。',
                            });
                        },
                        success : function (data, response, status) {
                            $.messager.progress('close');
                            if(data>0){
                                $.messager.show({
                                    title:'提示',
                                    msg:'修改用户信息成功',
                                });
                                $('#manager_edit').dialog('close').form('reset');
                                $('#manager').datagrid('reload');
                            }else{
                                $.messager.alert('修改失败','未知错误导致！','warning');
                            }
                        }
                    });
                }
            },
        },{
            text:'取消',
            iconCls:'icon-edit',
            handler:function () {
                $('#manager_edit').form('reset');
                $('#manager_edit').dialog('close').close();
            },
        }]
    });

    //管理账号
    $('input[name="manager"]').validatebox({
       required:true,
       validType:'length[2,20]',
       missingMessage:'请输入管理名称',
        invalidMessage:'管理名称在2-20位',
    });
    //管理密码
    $('input[name="password"]').validatebox({
        required:true,
        validType:'length[6,30]',
        missingMessage:'请输入管理密码',
        invalidaMessage:'管理密码在6-30位',
    });
    //修改管理密码
    $('input[name="password_edit"]').validatebox({
        validType:'length[6,30]',
        missingMessage:'请输入管理密码',
        invalidaMessage:'管理密码在6-30位',
    });
    //分配权限
    $('#auth').combotree({
        url:'/nav/getAll',
        required:true,
        lines:true,
        multiple:true,
        checkbox:true,
        onlyLeafCheck:true,
        onLoadSuccess:function (node, data) {
            var _this=this;
            if(data){
                $(data).each(function (index, value) {
                    if(this.state=='closed'){
                        $(_this).tree('expandAll');
                    }
                });
            }
        },
    });
    //管理员工具
    manager_tool={
        add:function () {
            $('#manager_add').dialog('open');
            $('input[name="manager"]').focus();
        },
        //取消所有选定
        redo:function () {
            $('#manager').datagrid('unselectAll');
        },
        //当前页面刷新
        reload:function () {
          $('#manager').datagrid('reload');
        },
        remove:function () {
            var rows=$('#manager').datagrid('getSelections');
            if(rows.length>0){
                $.messager.confirm('确定操作','你正要删除所选的记录吗？',function (flag) {
                    if(flag){
                        var ids=[];
                        for(var i=0;i<rows.length;i++){
                            ids.push(rows[i].id);
                        }
                        $.ajax({
                            type:'POST',
                            url:'/admin/delAdmin',
                            data:{
                                ids:ids.join(','),
                            },
                            beforeSend:function () {
                                $('#manager').datagrid('loading');
                            },
                            success:function (data) {
                                if(data){
                                    $('#manager').datagrid('loaded');
                                    $('#manager').datagrid('reload');
                                    $('#manager').datagrid('unselectAll');
                                    $.messager.show({
                                        title:'提示',
                                        msg:data+'个用户被删除成功！',
                                    });
                                }
                            }
                        })
                    }
                });

            }
            else{
                $.messager.alert('警告操作','删除记录至少一条数据！','warning');
            }
        },
        edit:function () {
            var rows=$('#manager').datagrid('getSelections');
            if(rows.length>1){
                $.messager.alert('警告操作!','编辑记录只能选择一条','warning');
            }else if(rows.length==1){
                $.ajax({
                    url:'/admin/getAdmin',
                    type:'get',
                    data:{
                        id:rows[0].id,
                    },
                    beforeSend:function () {
                        $.messager.progress({
                            text:'正在查询中。。。',
                        });
                    },
                    success : function (data, response, status) {
                        $.messager.progress('close');
                        if(data){

                           $('#manager_edit').form('load',{
                               id:data.id,
                               manager_edit:data.userName,
                               auth_edit:data.auth,
                           }).dialog('open');
                            //分配权限
                            $('#auth_edit').combotree({
                                url:'/nav/getAll',
                                required:true,
                                lines:true,
                                multiple:true,
                                checkbox:true,
                                onlyLeafCheck:true,
                                onLoadSuccess:function (node, data) {
                                    var _this=this;
                                    if(data){
                                        $(data).each(function (index, value) {
                                            if(this.state=='closed'){
                                                $(_this).tree('expandAll');
                                            }
                                        });
                                    }
                                },
                            });

                        }else{
                            $.messager.alert('查询失败','未知错误导致！','warning');
                        }
                    }
                });
            }else{
                $.messager.alert('警告操作!','必须选择编辑记录','warning');
            }
        },
    }

});



