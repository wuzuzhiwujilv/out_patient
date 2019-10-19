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

    //给所有图片元素绑定 change 事件
    $('.img-file').each(function(){
      var defaultImg = $(this).attr('id') + '-default';
      var resultImg = $(this).attr('id') + '_result';
      $(this).bind("change", function(){       
          onFileChange(this,resultImg,defaultImg);
      });
    });

    /**
     * 选中图片时的处理
     * @param {*} fileObj input file元素
     * @param {*} el //选中后用于显示图片的元素ID
     * @param {*} btnel //未选中图片时显示的按钮区域ID
     */
    function onFileChange(fileObj,el,btnel){
      var windowURL = window.URL || window.webkitURL;
      var dataURL;
      var imgObj = document.getElementById(el);
      document.getElementById(btnel).style.display="none";
      imgObj.style.display="block";
      if (fileObj && fileObj.files && fileObj.files[0]) {
          dataURL = windowURL.createObjectURL(fileObj.files[0]);
          imgObj.src=dataURL;
      } else {
          dataURL = fileObj.value;
          imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
          imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
      }
    }
    /**
     * 将图片压缩后返回base64格式的数据
     * @param {*} image img元素
     * @param {*} width 压缩后图片宽度
     * @param {*} height 压缩后图片高度
     * @param {*} qua //图片质量1-100
     */
    function compressImageTobase64(image,width,height,qua){
        var quality = qua ? qua / 100 : 0.8;
        var canvas = document.createElement("canvas"),     
            ctx = canvas.getContext('2d');     
        var w = image.naturalWidth,     
            h = image.naturalHeight;     
        canvas.width = width||w;     
        canvas.height = height||h;     
        ctx.drawImage(image, 0, 0, w, h, 0, 0, width||w, height||h);
        var data = canvas.toDataURL("image/jpeg", quality);     
        return data;
    }

    //获取表格内容
    function getFormData(){

      var formData = {
        
      };
      
      //获取输入框(input)内容
      var form = document.getElementById('routineTest');
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

      //获取图片内容
      $('.img-file').each(function(){
        var resultImg = $(this).attr('id') + '_result';
        var img_data=compressImageTobase64(document.getElementById(resultImg),500,300,90);
        formData[resultImg] = img_data;
      });

      return formData;
    }
    
    

    var button = document.getElementById("submit"); 
    button.onclick = function(){
      console.log(getFormData());
      var formData = getFormData();
      $.ajax({
          url : getRootPath()+"/routine/addForm",
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