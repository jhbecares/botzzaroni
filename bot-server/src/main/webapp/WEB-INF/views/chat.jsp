

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<script type="text/javascript"
	src="<spring:url value="/resources/js/jQuery/jquery.min.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>

<link href="<spring:url value="/resources/css/bootstrap.min.css"/>"
	type="text/css" rel="stylesheet">

<link href="<spring:url value="/resources/css/chat.css"/>"
	type="text/css" rel="stylesheet">

<link
	href="<spring:url value="/resources/css/font-awesome/font-awesome.min.css"/>"
	type="text/css" rel="stylesheet">

<link
	href="<spring:url value="/resources/css/font-awesome/icon-font.css"/>"
	type="text/css" rel="stylesheet">


<div class="container">
	<div class="row form-group">
		<div
			class="col-xs-12 col-md-offset-2 col-md-8 col-lg-8 col-lg-offset-2">
			<div class="panel panel-primary">
				<div class="panel-heading">

					<span class="fa fa-pie-chart fa-2x"></span> Botzzaroni
					<div class="btn-group pull-right open">

						<div class="btn-group pull-right">
							<a class="btn btn-default btn-sm" onclick="document.forms['logoutForm'].submit()"> <i
								class="fa fa-sign-out"></i> Cerrar sesión
							</a>
						 <c:if test="${pageContext.request.userPrincipal.name != null}">
					        <form id="logoutForm" method="POST" action="${contextPath}/logout">
					            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					        </form>
					    </c:if>
						</div>
					</div>
				</div>
				<div class="panel-body body-panel" style="min-height: 450;min-width: 700;">
					<ul class="chat">
						<li class="left clearfix">
							<span class="chat-img pull-left">
								<img src="http://placehold.it/50/55C1E7/fff&text=B" alt="User Avatar" class="img-circle" />
							</span>
							<div class="chat-body clearfix">
								<div class="header">
									<strong class="primary-font">Botzza</strong> 
									<small class="pull-right text-muted"> 
										<span class="glyphicon glyphicon-time"> </span> Hace 14 minutos
									</small>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</p>
							</div>
						</li>
						<li class="right clearfix">
							<span class="chat-img pull-right">
								<img src="http://placehold.it/50/FA6F57/fff&text=YO" alt="User Avatar" class="img-circle" />
							</span>
							<div class="chat-body clearfix">
								<div class="header">
									<strong class="pull-right primary-font">Bé</strong>
									<small class=" text-muted">
										<span class="glyphicon glyphicon-time"></span> Hace 15 minutos
									</small> 
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</p>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel-footer clearfix">
					<textarea id="text" class="form-control" rows="3"></textarea>
					<span
						class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-xs-12"
						style="margin-top: 10px">
						<button class="btn btn-success btn-lg btn-block" id="btn-chat">Enviar</button>
					</span>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn-chat').click(function() {
			var texto = $('#text').val(); 
		    $('.chat').append(
		    	'<li class="right clearfix">' +
					'<span class="chat-img pull-right">' +
						'<img src="http://placehold.it/50/FA6F57/fff&text=YO" alt="User Avatar" class="img-circle" />' +
					'</span>' +
					'<div class="chat-body clearfix">' +
						'<div class="header">' +
							'<strong class="pull-right primary-font">Bé</strong>' +
							'<small class=" text-muted"> ' +
								'<span class="glyphicon glyphicon-time"></span> Hace 15 minutos ' +
							'</small>' +
						'</div>' +
						'<p>' + texto + '</p>' +
					'</div>' +
				'</li>')
		});		
	});
</script>
