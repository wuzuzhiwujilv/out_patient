(function() {
    'use strict';

    // 检测必填信息
    
//    window.addEventListener('load', function() {
//      var forms = document.getElementsByClassName('needs-validation');
//      var validation = Array.prototype.filter.call(forms, function(form) {
//        form.addEventListener('submit', function(event) {
//          if (form.checkValidity() === false) {
//            event.preventDefault();
//            event.stopPropagation();
//          }
//          form.classList.add('was-validated');
//        }, false);
//      });
//    }, false);
 
    $("#nameValidate").hide();
    $("#idValidate").hide();
    loadQN();
    function loadQN(){
    	var idCard = $("#idCard").val();
    	$.ajax({
    		url : getRootPath() + "/patient/loadQN",
    		type : "POST",
    		data : {
    			"idCard" : idCard
    		},
    		success : function(data) {
    			if (data.success) {
    				var qn = data.data;
    				if(qn != null){
    					$("#name").val(qn.name);
        				$("#idCard").val(qn.idCard);
    				}
    				
    			} 
    		}
    	});
    }
      
    //配置datetimepicker
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
    });

    //获取表格内容
    function getFormData(){

      var formData = {
        'pregnancyDiseases' : [], //母亲孕期疾病史
        'joinSports' : []         //孩子参加固定的体育活动
      };
      
      //获取输入框(input)内容
      var form = document.getElementById('eye');
      var inputElements = form.getElementsByClassName('form-control');  
      for (var j = 0; j < inputElements.length; j++){
          if(inputElements[j].id){
            formData[inputElements[j].id] = inputElements[j].value;
          }    
      }

      //获取下拉框(select)内容
      $('.custom-select').each(function(){
        formData[$(this).attr('id')] = $(this).find("option:selected").val();
      });

      //获取Radio内容
      var familyIncome = $('input:radio[name="familyIncome"]:checked').val();
      if(familyIncome){
        formData['familyIncome'] = familyIncome;
      }else{
        formData['familyIncome'] = '';
      }
      var whetherSport = $('input:radio[name="whetherSport"]:checked').val();
      if(whetherSport){
        formData['whetherSport'] = whetherSport;
      }else{
        formData['whetherSport'] = '';
      }

      //获取checkbox内容
      $('input:checkbox[name="pregnancyDiseases"]:checked').each(function(){
        formData['pregnancyDiseases'].push($(this).val());
      });
      $('input:checkbox[name="joinSports"]:checked').each(function(){
        formData['joinSports'].push($(this).val());
      });

      //获取date time picker value for birthday
      formData['dtp_birthday'] = $('#dtp_birthday').val();

      return formData;
    }
    
    

    var button = document.getElementById("submit"); 
    button.onclick = function(){
      var formData = getFormData();
      $("#nameValidate").hide();
      $("#idValidate").hide();
      if(isEmpty(formData.name)){
    	  $("#nameValidate").show();
      }
      if(isEmpty(formData.idCard)){
    	  $("#idValidate").show();
      }
      $.ajax({
    	  url : getRootPath() + "/patient/saveQN",
          type : "POST",
          data : formData,
          success : function(data) {
  			if (data.success) {
  				showSuccessMsg();
			}else{
				showErrorMsg();
			} 
		},
          error : showErrorMsg,
          dataType : "json"
      });
    }
    //显示提交成功提示信息
    function showSuccessMsg(){
      $('#successMsg').modal('show');
    }
    //显示提交失败提示信息
    function showErrorMsg(){
      $('#errorMsg').modal('show');
    }
    var okNext = document.getElementById("okNext"); 
    okNext.onclick = function(){
    	window.location.href = getRootPath() + '/patient/goQN';
    }
  })();