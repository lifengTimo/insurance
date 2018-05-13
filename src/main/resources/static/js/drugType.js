//药品限制--> 性别限制
$(function(){
	$('#drugTypeTable').datagrid({
        url:'/drugType/getAll',
        fit:true,
        fitColumns:true,
        striped:true,
        border:false,
        pagination:true,
        pageSize:20,
        pageList:[10,20,30,40,50],
        pageNumber:1,
        sortName:'createTime',
        sortOder:'desc',
        toolbar:'#drugType_tool',
        columns:[[
            {
                field:'id',
                title:'自动编号',
                width:100,
                checkbox:true,
            },
            {
                field:'drug',
                title:'药品编码',
                width:100,
                formatter: function(value,row,index){
                    if (row.drug){
                        return row.drug.drugCode;
                    } else {
                        return value;
                    }
                },
            },
            {
                field:'drug.drugName',
                title:'药品名称',
                width:100,
                formatter: function(value,row,index){
                    if (row.drug){
                        return row.drug.drugName;
                    } else {
                        return value;
                    }
                },
            },
            {
                field:'insuranceType',
                title:'报销险种限制',
                width:50,
                formatter: function(value,row,index){
                    return value.valueName;
                },
            },
            {
                field:'createTime',
                title:'创建时间',
                width:100,
            },

        ]],
        cache: false
    });


	//操作员添加
    $('#drugType_add').dialog({
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
                var g =  $('#TypeLimitDrugCode').combogrid('grid');
                var r = g.datagrid('getSelected');
                var  json={
                    drug:r,
                    insuranceType:{
                        id:$('#TypeLimitInput option:selected') .val(),
                        valueName:$('#TypeLimitInput option:selected') .text(),
                        dictCode:"INSURANCE_TYPE"}
                };
                if($('#drugType_add').form('validate')){
                    $.ajax({
                        url:'/drugType/insert',
                        type:'post',
                        contentType : 'application/json;charset=utf-8', //设置请求头信息
                        dataType : "json",
                        data:JSON.stringify(json), //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
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
                                $('#drugType_add').dialog('close').form('reset');
                                $('#drugTypeTable').datagrid('reload');
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
                $('#drugType_add').form('reset');
                $('#drugType_add').dialog('close').close();
            },
        }]
    });
    //操作员修改
    $('#drugType_edit').dialog({
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
                    var  json={
                        id:$('#id').val(),
                        drug:{
                            id:$('#drugId').val(),
                        },
                        insuranceType:{
                            id:$('#TypeLimitInputEdit option:selected') .val(),
                        }
                    };

                    $.ajax({
                        url:'/drugType/insert',
                        type:'put',
                        async: true,
                        contentType : 'application/json;charset=utf-8', //设置请求头信息
                        dataType : "json",
                        data:JSON.stringify(json), //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
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
                                $('#drugType_edit').dialog('close').form('reset');
                                $('#drugTypeTable').datagrid('reload');
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
                $('#drugType_edit').form('reset');
                $('#drugType_edit').dialog('close').close();
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
    drugType_tool={
        add:function () {
            $('#drugType_add').dialog('open');
            $('input[name="drugCode"]').focus();
        },
        //取消所有选定
        redo:function () {
            $('#drugTypeTable').datagrid('unselectAll');
        },
        //当前页面刷新
        reload:function () {
          $('#drugTypeTable').datagrid('reload');
        },
        remove:function () {
            var rows=$('#drugTypeTable').datagrid('getSelections');
            if(rows.length>0){
                $.messager.confirm('确定操作','你正要删除所选的记录吗？',function (flag) {
                    if(flag){
                        var ids=[];
                        for(var i=0;i<rows.length;i++){
                            ids.push(rows[i].id);
                        }
                        $.ajax({
                            type:'POST',
                            url:'/drugType/del',
                            data:{
                                ids:ids.join(','),
                            },
                            beforeSend:function () {
                                $('#drugTypeTable').datagrid('loading');
                            },
                            success:function (data) {
                                if(data){
                                    $('#drugTypeTable').datagrid('loaded');
                                    $('#drugTypeTable').datagrid('reload');
                                    $('#drugTypeTable').datagrid('unselectAll');
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
            var rows=$('#drugTypeTable').datagrid('getSelections');
            if(rows.length>1){
                $.messager.alert('警告操作!','编辑记录只能选择一条','warning');
            }else if(rows.length==1){
                $.ajax({
                    url:'/drugType/getOne',
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
                           $('#drugType_edit').form('load',{
                               id:data.id,
                               drugCode:data.drug.drugName,
                               drugId:data.drug.id,
                               TypeLimit:data.insuranceType.id,
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



