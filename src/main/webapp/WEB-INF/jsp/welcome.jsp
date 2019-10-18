<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="author" content="colorlib.com">
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500"
	rel="stylesheet" />
<link href="css/main.css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
<link href="js/multi.js" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>MPSP - Home</title>
</head>
<body>
	<div class="s002">
		<div>
			<form class="input-field fifth-wrap inner-form"
				action="${contextPath}/logout">
				<input
					style="position: absolute; right: 0; margin: 3%; top: 0; border-radius: 20px; cursor: pointer;"
					type="submit" value="Logout" />
			</form>
		</div>

		<form method="POST" action="${contextPath}/search">
			<fieldset>
				<legend>SEARCH CPF / CNPJ</legend>
			</fieldset>
			<div class="inner-form">
				<div class="input-field first-wrap">
					<input id="search" type="text" name="cpfCnpj"
						placeholder="Insert CPF/CNPJ for a specific search or Select 'ALL' for no filter search" />
				</div>
				<div class="input-field fouth-wrap">
					<select data-trigger="" name="tipoBusca" required="required">
						<option name="1" value="" disabled="disabled" selected="selected">Select
							an option</option>
						<option name="cpf" value="cpf">CPF</option>
						<option name="cnpj" value="cnpj">CNPJ</option>
						<option name="all" value="all">ALL</option>
					</select>
				</div>
				<div class="input-field fouth-wrap">
					<select data-trigger="" name="select" required="required">
						<!-- <option name="1" value="" disabled="disabled" selected="selected">Select
							an option</option> -->
						<option value="All">ALL</option>
						<option value="Arisp">Arisp</option>
						<option value="Arpenp">Arpenp</option>
						<option value="Cadesp">Cadesp</option>
						<option value="Caged">Caged</option>
						<option value="Censec">Censec</option>
						<option value="Detran">Detran</option>
						<option value="Infocrim">Infocrim</option>
						<option value="Jucesp">Jucesp</option>
						<option value="Siel">Siel</option>
						<option value="Sivec">Sivec</option>
					</select>
				</div>
			</div>
			<br>
			<div class="input-field fifth-wrap inner-form">
				<button class="btn-search" type="submit" style="width: 100%">SEARCH</button>
			</div>
		</form>
	</div>
	<script src="js/extention/choices.js"></script>
	<script src="js/extention/flatpickr.js"></script>
	<script>
		flatpickr(".datepicker", {});
	</script>
	<script>
		const choices = new Choices('[data-trigger]', {
			searchEnabled : false,
			itemSelectText : '',
		});
	</script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
