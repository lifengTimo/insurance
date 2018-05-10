//药品限制--> 性别限制
$(function(){
	$('#drugSexTable').datagrid({
        url:'/sexLimit/getAll',
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
        toolbar:'#drugSex_tool',
        columns:[[
            {
                field:'id',
                title:'自动编号',
                width:100,
                checkbox:true,
            },
            {
                field:'drugCode',
                title:'地方药品编码',
                width:100,
            },
            {
                field:'drugName',
                title:'地方药品名称',
                width:100,
            },
            {
                field:'promptMessageName',
                title:'限制男女',
                width:50,
            },
            {
                field:'createTime',
                title:'创建时间',
                width:100,
            },

        ]]
    });
	//操作员添加
    $('#drugSex_add').dialog({
        width: 350,
        title: '新增管理',
        iconCls:'icon-admin-add',
        modal:true,
        closed:true,
        buttons:[{
            text:'提交',
            iconCls:'icon-add',
            handler:function () {
                console.log("开始");
                var g =  $('#sexLimitDrugCode').combogrid('grid');
                var r = g.datagrid('getSelected');
                if($('#drugSex_add').form('validate')){
                    $.ajax({
                        url:'/sexLimit/insert',
                        type:'post',
                        data:{
                           drugCode:r.drugCode,
                            drugName:r.drugName,
                            promptMessage:$('#sexLimitInput option:selected') .val(),
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
                                    msg:'新增成功',
                                });
                                $('#drugSex_add').dialog('close').form('reset');
                                $('#drugSexTable').datagrid('reload');
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
                $('#drugSex_add').form('reset');
                $('#drugSex_add').dialog('close').close();
            },
        }]
    });
    //操作员修改
    $('#drugSex_edit').dialog({
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
                        url:'/sexLimit/update',
                        type:'put',
                        data:{
                            id:$('#id').val(),
                            drugCode:$('#sexLimitDrugCodeEdit').val(),
                            promptMessage:$('#sexLimitInputEdit option:selected') .val(),
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
                                $('#drugSex_edit').dialog('close').form('reset');
                                $('#drugSexTable').datagrid('reload');
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



    //药品编码
    $('input[name="drugCode"]').combogrid({
        panelWidth:500,
        url:'/drug/getAll',
        idField:'drugCode',
        textField:'drugName',
        mode:'remote',
        fitColumns:true,
        columns:[[
            {field:'drugCode',title:'药品编码',align:'center',width:120},
            {field:'drugName',title:'药品名称',align:'center',width:80},
            {field:'englishName',title:'药品英文名称',align:'center',width:60},
            {field:'startTime',title:'开始时间',align:'center',width:60},
            {field:'stopTime',title:'结束时间',align:'center',width:60},
            {field:'chargeType',title:'费用等级',align:'center',width:60}
        ]]
    });
    //管理员工具
    drugSex_tool={
        add:function () {
            $('#drugSex_add').dialog('open');
            $('input[name="manager"]').focus();
        },
        //取消所有选定
        redo:function () {
            $('#drugSexTable').datagrid('unselectAll');
        },
        //当前页面刷新
        reload:function () {
          $('#drugSexTable').datagrid('reload');
        },
        remove:function () {
            var rows=$('#drugSexTable').datagrid('getSelections');
            if(rows.length>0){
                $.messager.confirm('确定操作','你正要删除所选的记录吗？',function (flag) {
                    if(flag){
                        var ids=[];
                        for(var i=0;i<rows.length;i++){
                            ids.push(rows[i].id);
                        }
                        $.ajax({
                            type:'POST',
                            url:'/sexLimit/del',
                            data:{
                                ids:ids.join(','),
                            },
                            beforeSend:function () {
                                $('#drugSexTable').datagrid('loading');
                            },
                            success:function (data) {
                                if(data){
                                    $('#drugSexTable').datagrid('loaded');
                                    $('#drugSexTable').datagrid('reload');
                                    $('#drugSexTable').datagrid('unselectAll');
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
            var rows=$('#drugSexTable').datagrid('getSelections');
            if(rows.length>1){
                $.messager.alert('警告操作!','编辑记录只能选择一条','warning');
            }else if(rows.length==1){
                $.ajax({
                    url:'/sexLimit/getOne',
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
                            console.log(data);
                           $('#drugSex_edit').form('load',{
                               id:data.id,
                               drugCode:data.drugName,
                               sexLimit:data.promptMessage,
                           }).dialog('open');

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



