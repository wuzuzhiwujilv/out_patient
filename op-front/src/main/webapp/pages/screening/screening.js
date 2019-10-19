(function() {
    'use strict';

    // 检测必填信息
    /**
    window.addEventListener('load', function() {
      var forms = document.getElementsByClassName('needs-validation');
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
    console.log($("form").serializeArray());
    **/
      
    //获取表格内容
    function getFormData(){

      var formData = {

      };
      
      //获取输入框(input)内容
      var form = document.getElementById('screening');
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

      return formData;
    }
    
    

    var button = document.getElementById("submit"); 
    button.onclick = function(){
      console.log(getFormData());
      var formData = getFormData();
      $.ajax({
          url : getRootPath()+"/screening/addForm",
          async : true,
          type : "POST",
          data : formData,
          //成功后开启模态框
          success : showSuccessMsg,
          //失败后开启模态框
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
    
  })();