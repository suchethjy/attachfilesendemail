<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
   <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %> 
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>

<template:page pageTitle="${pageTitle}">
    <cms:pageSlot position="Section1" var="feature">
        <cms:component component="${feature}" />
    </cms:pageSlot>
    <div class="row no-margin">
        <div class="col-xs-12 col-md-6 no-space">
            <cms:pageSlot position="Section2A" var="feature" element="div" class="row no-margin">
                <cms:component component="${feature}" element="div" class="col-xs-12 col-sm-6 no-space yComponentWrapper"/>
            </cms:pageSlot>
        </div>
        <div class="col-xs-12 col-md-6 no-space">
            <cms:pageSlot position="Section2B" var="feature" element="div" class="row no-margin">
                <cms:component component="${feature}" element="div" class="col-xs-12 col-sm-6 no-space yComponentWrapper"/>
            </cms:pageSlot>
        </div>
        <div class="col-xs-12">
            <cms:pageSlot position="Section2C" var="feature" element="div" class="landingLayout2PageSection2C">
                <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
            </cms:pageSlot>
        </div>
    </div>

<%--   <form:form method="post" modelAttribute="emailAttachmentForm" action="/practicestorefront/electronics/en/sendEmail" enctype="multipart/form-data">
    <table>
        <tr>
        <formElement:formInputBox idKey="createTicket-subject" labelKey="text.account.supporttickets.createTicket.subject" " path="name" inputCSS="text" mandatory="true" />
           	 <div class="file-upload__wrapper btn btn-default btn-small">
                                <span> <spring:theme code="text.account.supporttickets.createTicket.chooseFile" text="Choose file"/> </span>
                                <input type="file" name="file" path="file"/>
                            </div>
        </tr>
        <tr>
            <td><form:button type="submit" value="Submit" /></td>
            <button class="btn btn-primary btn-block" type="submit" id="addTicket">
                                            <spring:theme code="text.account.supporttickets.createTicket.submit" text="Submit"/>
                                            </button>
        </tr>
    </table>
</form:form> --%>


<%--  
<form:form method = "POST" modelAttribute = "emailAttachmentForm" action="/practicestorefront/electronics/en/sendEmail" enctype="form-data"
          accept="text/csv">
       <input type="hidden" name="CSRFToken" value="${ycommerce:encodeJavaScript(CSRFToken.token)}" />
         Please select a file to upload : 
         <input type = "file" name = "file" />
         <input id="emailbutton8c" type = "submit" value = "upload" />
         
         
      </form:form> --%>
     
     
 

    <cms:pageSlot position="Section3" var="feature" element="div" class="row no-margin" >
        <cms:component component="${feature}" element="div" class="no-space yComponentWrapper"/>
    </cms:pageSlot>

    <cms:pageSlot position="Section4" var="feature" element="div" class="row no-margin">
        <cms:component component="${feature}" element="div" class="col-xs-6 col-md-3 no-space yComponentWrapper"/>
    </cms:pageSlot>

    <cms:pageSlot position="Section5" var="feature" element="div">
        <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
    </cms:pageSlot>
<script>


$( document ).ready(function() {
    alert( "ready!" );
});
$(document).on('click', '#emailbutton8c',
function (event) {
alert("test");
event.preventDefault();
$('#addTicket').prop('disabled',true);
var form = document.getElementById("supportTicketForm");
var formData = new window.FormData(form);

var selectedFile = document.getElementById('attachmentFiles');

$.ajax({
url: "",
type: 'POST',
data: formData,
contentType: false,
processData: false,
success: function () {
//window.location.replace(successRedirectUrl);
},
error: function (jqXHR) {
$(form).find(':submit').prop('disabled',false);

}
});

});

</script>

</template:page>

