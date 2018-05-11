//疾病险种->性别限制
$(function(){
	$('#diseaseGenderTable').datagrid({
        url:'/diseaseGender/getAll',
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
        toolbar:'#diseaseGender_tool',
        columns:[[
            {
                field:'id',
                title:'自动编号',
                width:100,
                checkbox:true,
            },
            {
                field:'diseaseCode',
                title:'疾病编码',
                width:100,
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
                title:'疾病名称',
                width:100,
                formatter: function(value,row,index){
                    if (row.disease){
                        return row.disease.diseaseName;
                    } else {
                        return value;
                    }
                },
            },
            {
                field:'genderLimit',
                title:'性别限制',
                width:50,
                formatter: function(value,row,index){
                    if (row.genderLimit.valueCode=='1'){
                        return '限制男性';
                    } else {
                        return '限制女性';
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


	//操作员添加
    $('#diseaseGender_add').dialog({
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
                var g =  $('#GenderLimitDrugCode').combogrid('grid');
                var r = g.datagrid('getSelected');
                var  json={
                    disease:r,
                    genderLimit:{
                        id:$('#GenderLimitInput option:selected') .val(),
                        dictCode:"SEX_DICT"}
                };
                if($('#diseaseGender_add').form('validate')){
                    $.ajax({
                        url:'/diseaseGender/insert',
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
                                $('#diseaseGender_add').dialog('close').form('reset');
                                $('#diseaseGenderTable').datagrid('reload');
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
                $('#diseaseGender_add').form('reset');
                $('#diseaseGender_add').dialog('close').close();
            },
        }]
    });
    //操作员修改
    $('#diseaseGender_edit').dialog({
        width: 350,
        title: '修改管理',
        iconCls:'icon-admin-add',
        modal:true,
        closed:true,
        buttons:[{
            text:'提交',
            iconCls:'icon-edit',
            handler:function () {
                if($('#diseaseGender_edit').form('validate')){
                    var  json={
                        id:$('#id').val(),
                        disease:{
                            id:$('#diseaseId').val(),
                        },
                        genderLimit:{
                            id:$('#GenderLimitInputEdit option:selected') .val(),
                        }
                    };

                    $.ajax({
                        url:'/diseaseGender/insert',
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
                                $('#diseaseGender_edit').dialog('close').form('reset');
                                $('#diseaseGenderTable').datagrid('reload');
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
                $('#diseaseGender_edit').form('reset');
                $('#diseaseGender_edit').dialog('close').close();
            },
        }]
    });



    //药品编码
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
    diseaseGender_tool={
        add:function () {
            $('#diseaseGender_add').dialog('open');
            $('input[name="drugCode"]').focus();
        },
        //取消所有选定
        redo:function () {
            $('#diseaseGenderTable').datagrid('unselectAll');
        },
        //当前页面刷新
        reload:function () {
          $('#diseaseGenderTable').datagrid('reload');
        },
        remove:function () {
            var rows=$('#diseaseGenderTable').datagrid('getSelections');
            if(rows.length>0){
                $.messager.confirm('确定操作','你正要删除所选的记录吗？',function (flag) {
                    if(flag){
                        var ids=[];
                        for(var i=0;i<rows.length;i++){
                            ids.push(rows[i].id);
                        }
                        $.ajax({
                            type:'POST',
                            url:'/diseaseGender/del',
                            data:{
                                ids:ids.join(','),
                            },
                            beforeSend:function () {
                                $('#diseaseGenderTable').datagrid('loading');
                            },
                            success:function (data) {
                                if(data){
                                    $('#diseaseGenderTable').datagrid('loaded');
                                    $('#diseaseGenderTable').datagrid('reload');
                                    $('#diseaseGenderTable').datagrid('unselectAll');
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
            var rows=$('#diseaseGenderTable').datagrid('getSelections');
            if(rows.length>1){
                $.messager.alert('警告操作!','编辑记录只能选择一条','warning');
            }else if(rows.length==1){
                $.ajax({
                    url:'/diseaseGender/getOne',
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
                           $('#diseaseGender_edit').form('load',{
                               id:data.id,
                               diseaseName:data.disease.diseaseName,
                               diseaseId:data.disease.id,
                               genderLimit:data.genderLimit.id,
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



