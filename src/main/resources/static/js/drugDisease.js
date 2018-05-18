//药品限制--> 性别限制
$(function(){
	$('#drugDrugDiseaseTable').datagrid({
        url:'/drugDisease/getAll',
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
        toolbar:'#drugDrugDisease_tool',
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
                width:60,
                formatter: function(value,row,index){
                    if (row.drug){
                        return row.drug.drugCode;
                    } else {
                        return value;
                    }
                },
            },
            {
                field:'drugName',
                title:'地方药品名称',
                width:80,
                formatter: function(value,row,index){
                    if (row.drug){
                        return row.drug.drugName;
                    } else {
                        return value;
                    }
                },
            },
            {
                field:'diseaseCode',
                title:'限制疾病编码',
                width:60,
                formatter: function(value,row,index){
                    if (row.disease){
                        return row.disease.diseaseCode;
                    } else {
                        return value;
                    }
                },
            },
            {
                field:'diseaseName',
                title:'限制疾病名称',
                width:80,
                formatter: function(value,row,index){
                    if (row.disease){
                        return row.disease.diseaseName;
                    } else {
                        return value;
                    }
                },
            },
            {
                field:'createTime',
                title:'创建时间',
                width:100,
            },

        ]]
    });
	//添加
    $('#drugDrugDisease_add').dialog({
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
                var g =  $('#DrugDiseaseLimitDrugCode').combogrid('grid');
                var r = g.datagrid('getSelected');

                var a =  $('#diseaseLimitInput').combogrid('grid');
                var b = a.datagrid('getSelected');
                var  json={
                    drug:r,
                   disease:b,
                };
                if($('#drugDrugDisease_add').form('validate')){
                    $.ajax({
                        url:'/drugDisease/insert',
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
                                $('#drugDrugDisease_add').dialog('close').form('reset');
                                $('#drugDrugDiseaseTable').datagrid('reload');
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
                $('#drugDrugDisease_add').form('reset');
                $('#drugDrugDisease_add').dialog('close').close();
            },
        }]
    });
    //操作员修改
    $('#drugDrugDisease_edit').dialog({
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
                    console.log("开始");
                    var id=$('#drugDrugDisease_edit #id').val();

                   var drugId=$('#drugDrugDisease_edit #drugId').val();

                    var a =  $('#DrugDiseaseLimitInputEdit').combogrid('grid');
                    var b = a.datagrid('getSelected');
                    var  json={
                        id:id,
                        drug:{
                            id:drugId
                        },
                        disease:b,
                    };

                    $.ajax({
                        url:'/drugDisease/insert',
                        type:'put',
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
                                $('#drugDrugDisease_edit').dialog('close').form('reset');
                                $('#drugDrugDiseaseTable').datagrid('reload');
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
                $('#drugDrugDisease_edit').form('reset');
                $('#drugDrugDisease_edit').dialog('close').close();
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

    //疾病编码
    $('input[name="disease"]').combogrid({
        panelWidth:500,
        url:'/disease/getAll',
        idField:'diseaseCode',
        textField:'diseaseName',
        mode:'remote',
        fitColumns:true,
        columns:[[
            {field:'diseaseCode',title:'ICD10疾病编码',align:'center',width:120},
            {field:'diseaseName',title:'疾病名称',align:'center',width:80},
            {field:'pinyin',title:'拼音简码',align:'center',width:60},
            {field:'startDate',title:'开始日期',align:'center',width:60},
            {field:'stopDate',title:'结束日期',align:'center',width:60},
            {field:'status',title:'状态',align:'center',width:60,formatter: function(value,row,index){
                    if (value=='1'){
                        return '有效';
                    } else {
                        return '无效';
                    }
                },}
        ]]
    });
    //管理员工具
    drugDrugDisease_tool={
        add:function () {
            $('#drugDrugDisease_add').dialog('open');
            $('input[name="drugCode"]').focus();
        },
        //取消所有选定
        redo:function () {
            $('#drugDrugDiseaseTable').datagrid('unselectAll');
        },
        //当前页面刷新
        reload:function () {
          $('#drugDrugDiseaseTable').datagrid('reload');
        },
        remove:function () {
            var rows=$('#drugDrugDiseaseTable').datagrid('getSelections');
            if(rows.length>0){
                $.messager.confirm('确定操作','你正要删除所选的记录吗？',function (flag) {
                    if(flag){
                        var ids=[];
                        for(var i=0;i<rows.length;i++){
                            ids.push(rows[i].id);
                        }
                        $.ajax({
                            type:'POST',
                            url:'/drugDisease/del',
                            data:{
                                ids:ids.join(','),
                            },
                            beforeSend:function () {
                                $('#drugDrugDiseaseTable').datagrid('loading');
                            },
                            success:function (data) {
                                if(data){
                                    $('#drugDrugDiseaseTable').datagrid('loaded');
                                    $('#drugDrugDiseaseTable').datagrid('reload');
                                    $('#drugDrugDiseaseTable').datagrid('unselectAll');
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
            var rows=$('#drugDrugDiseaseTable').datagrid('getSelections');
            if(rows.length>1){
                $.messager.alert('警告操作!','编辑记录只能选择一条','warning');
            }else if(rows.length==1){
                $.ajax({
                    url:'/drugDisease/getOne',
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
                           $('#drugDrugDisease_edit').form('load',{
                               id:data.id,
                               drugId:data.drug.id,
                               drugCode:data.drug.drugName,
                               disease:data.disease.diseaseName,
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



