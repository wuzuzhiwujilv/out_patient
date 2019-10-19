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

    function getImgContainer(){
      var imgContainer = document.createElement("div");
      imgContainer.className = "img-container col-md-4 mb-3";
      var input = document.createElement("input");
      input.type = "file";
      input.className = "img-file";
      input.id = "img-specialTest-" + $('#special-test-imgs').children().length;
      input.accept = "image/*";
      imgContainer.appendChild(input);
      var div = document.createElement("div");
      div.id = input.id + "-default";
      var defaultImg = document.createElement('img');
      defaultImg.style = "width:4rem";
      defaultImg.src = "${ctx!}/images/camera.png";
      defaultImg.alt = "";
      div.appendChild(defaultImg);
      imgContainer.appendChild(div);
      var resultImg = document.createElement('img');
      resultImg.style = "width: 100%";
      resultImg.id = input.id + "-result";
      imgContainer.appendChild(resultImg); 
      input.addEventListener("change", function(){
        onFileChange(input,resultImg.id,div.id);
      });
      return imgContainer;
    }
    //添加图片change事件
    document.getElementById("img-specialTest").addEventListener("change", function(){       
        onFileChange(this,"img-specialTest-result","img-specialTest-default");
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

      //添加多张图片
      if(fileObj.parentNode === document.getElementById('special-test-imgs').lastElementChild){
        document.getElementById('special-test-imgs').appendChild(getImgContainer());
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
       'mydriatic':[]
     };
      
      //获取输入框(input)内容
      var form = document.getElementById('specialTest');
      var inputElements = form.getElementsByClassName('form-control');  
      for (var j = 0; j < inputElements.length; j++){
          if(inputElements[j].id){
            formData[inputElements[j].id] = inputElements[j].value;
          }    
      }

      //获取图片信息
      $('.img-file').each(function(){
        var resultImg = $(this).attr('id') + '-result';
        var img_data=compressImageTobase64(document.getElementById(resultImg),500,300,90);
        formData[resultImg] = img_data;
      });

      //获取checkbox内容
      $('input:checkbox[name="mydriatic"]:checked').each(function(){
        formData['mydriatic'].push($(this).val());
      });

      return formData;
    }
    
    

    var button = document.getElementById("submit"); 
    button.onclick = function(){
      console.log(getFormData());
      var formData = getFormData();
      $.ajax({
          url : getRootPath()+"/special/addForm",
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