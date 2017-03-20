

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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
							<a class="btn btn-default btn-sm" href="#"> <i
								class="fa fa-sign-out"></i> Cerrar sesi�n
							</a>
						</div>
					</div>
				</div>
				<div class="panel-body body-panel" style="min-height: 450;min-width: 700;">
					<ul class="chat">
						<li class="left clearfix"><span class="chat-img pull-left">
								<img src="http://placehold.it/50/55C1E7/fff&text=B"
								alt="User Avatar" class="img-circle" />
						</span>
							<div class="chat-body clearfix">
								<div class="header">
									<strong class="primary-font">Botzza</strong> <small
										class="pull-right text-muted"> <span
										class="glyphicon glyphicon-time"></span>Hace 14 minutos
									</small>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Curabitur bibendum ornare dolor, quis ullamcorper ligula
									sodales.</p>
							</div></li>
						<li class="right clearfix"><span class="chat-img pull-right">
								<img src="http://placehold.it/50/FA6F57/fff&text=YO"
								alt="User Avatar" class="img-circle" />
						</span>
							<div class="chat-body clearfix">
								<div class="header">
									<small class=" text-muted"><span
										class="glyphicon glyphicon-time"></span>Hace 14 minutos</small> <strong
										class="pull-right primary-font">B�</strong>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Curabitur bibendum ornare dolor, quis ullamcorper ligula
									sodales.</p>
							</div></li>
						<li class="left clearfix"><span class="chat-img pull-left">
								<img src="http://placehold.it/50/55C1E7/fff&text=B"
								alt="User Avatar" class="img-circle" />
						</span>
							<div class="chat-body clearfix">
								<div class="header">
									<strong class="primary-font">Botzza</strong> <small
										class="pull-right text-muted"> <span
										class="glyphicon glyphicon-time"></span>Hace 14 minutos
									</small>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Curabitur bibendum ornare dolor, quis ullamcorper ligula
									sodales.</p>
							</div></li>
						<li class="right clearfix"><span class="chat-img pull-right">
								<img src="http://placehold.it/50/FA6F57/fff&text=YO"
								alt="User Avatar" class="img-circle" />
						</span>
							<div class="chat-body clearfix">
								<div class="header">
									<small class=" text-muted"><span
										class="glyphicon glyphicon-time"></span>Hace 15 minutos</small> <strong
										class="pull-right primary-font">B�</strong>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Curabitur bibendum ornare dolor, quis ullamcorper ligula
									sodales.</p>
							</div></li>
					</ul>
				</div>
				<div class="panel-footer clearfix">
					<textarea class="form-control" rows="3"></textarea>
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

