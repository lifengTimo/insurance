$(function () {
    //医院编码
    $('#txtHospital').combogrid({
        panelWidth:500,
        url:'/hospital/getAll',
        idField:'id',
        textField:'hospitalName',
        mode:'remote',
        fitColumns:true,
        columns:[[
            {field:'id',title:'编号',align:'center',width:40},
            {field:'hospitalNo',title:'医院编码',align:'center',width:40},
            {field:'hospitalName',title:'医院名称',align:'center',width:200},
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

    $("#btnSearch").click(function () {
        var  name=$('#personName').val();
        var idCard=$('#txtFullName').val();
        var hospitalId=$('#txtHospital').val();
        var startTime=$("#startTime").val();
        var endTime=$('#endTime').val();
       // alert(name+"||"+hospitalId+"||"+startTime+"||"+endTime+"||"+startTime+"||"+idCard);
       /*$.get("/record/getAllBy",
            { name: name, idCard: idCard,hospitalId:hospitalId,startTime:startTime,endTime:endTime},
            function(data){
                alert("Data Loaded: " + data);
            });*/
        $('#recordTable').datagrid('load',{
            name: name, idCard: idCard,hospitalId:hospitalId,startTime:startTime,endTime:endTime
        });
    });

    $('#recordTable').datagrid({
        //单击事件
        onClickRow:function(rowIndex,rowData){
            var rows=$('#recordTable').datagrid('getSelections');
            $.ajax({
                url:'/record/getOne',
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

                        $('#idCard').html(data.outp.patient.idNo);
                        $('#name').html(data.outp.patient.name);
                        $('#sex').html(data.outp.patient.sex.valueName);
                        $('#hospitalNo').html(data.outp.hospital.hospitalNo);
                        $('#hospitalName').html(data.outp.hospital.hospitalName);
                        $('#diseaseName').html(data.outp.disease.diseaseName);
                       $('#money').html(data.outp.toalCost);
                        $('#createTime').html(data.createTime);
                        $('#record').html(data.record);
                        $('#DivView').dialog('open');

                    }else{
                        $.messager.alert('查询失败','未知错误导致！','warning');
                    }
                }
            });
        }

    });
})