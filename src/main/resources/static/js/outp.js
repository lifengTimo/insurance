$(function () {
    //药品编码
    $('input[name="topDisease"]').combogrid({
        panelWidth:500,
        url:'/disease/getAll',
        idField:'id',
        textField:'diseaseName',
        mode:'remote',
        fitColumns:true,
        columns:[[
            {field:'id',title:'编号',align:'center',width:40},
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


    //医院编码
    $('input[name="topHospital"]').combogrid({
        panelWidth:500,
        url:'/hospital/getAll',
        idField:'id',
        textField:'hospitalName',
        mode:'remote',
        fitColumns:true,
        columns:[[
            {field:'id',title:'编号',align:'center',width:40},
            {field:'hospitalNo',title:'医院编码',align:'center',width:120},
            {field:'hospitalName',title:'医院名称',align:'center',width:80},
            {field:'pinyin',title:'拼音简码',align:'center',width:60},
            {field:'type',title:'类型',align:'center',width:60,formatter: function(value,row,index){
                    if (value.type){
                        return  value.type.valueName;
                    } else {
                        return '';
                    }
                },},
            {field:'createTime',title:'创建时间',align:'center',width:60}

        ]]
    });

    $("input[name='idNo']").bind('keypress',function(event){

        var idNoText=$("input[name='idNo']").val();
        $('#name').html();
        $('#sex').html();
        $('#age').html();
        $('#id').html();
        $.get(
            "/patient/getOne",
            { idNo:idNoText },
            function(data){
                $('#name').html(data.name);
                $('#sex').html(data.sex.valueName);
                $('#age').html(data.age);
                $('#id').html(data.id);
            });
    });




})