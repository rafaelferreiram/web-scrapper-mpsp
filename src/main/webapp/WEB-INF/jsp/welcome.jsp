<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="author" content="colorlib.com">
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500"
	rel="stylesheet" />
<link href="css/main.css" rel="stylesheet" />
<link href="js/multi.js" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="s002">
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
					<select data-trigger="" name="tipoBusca">
						<option placeholder="" name="cpf" value="cpf">CPF</option>
						<option name="cnpj" value="cnpj">CNPJ</option>
					</select>
				</div>
				<br></br>
				<div>
					<div class="container">

						<select name="select">
							<option data-count="2" value="All">All</option>
							<option data-count="2" value="Arisp">Arisp</option>
							<option data-count="23" value="Arpenp">Arpenp</option>
							<option data-count="433" value="Cadesp">Cadesp</option>
							<option data-count="45" value="Caged">Caged</option>
							<option data-count="476" value="Censec">Censec</option>
							<option data-count="78" value="Detran">Detran</option>
							<option data-count="123" value="Infocrim">Infocrim</option>
							<option data-count="32" value="Jucesp">Jucesp</option>
							<option data-count="32" value="Siel">Siel</option>
							<option data-count="32" value="Sivec">Sivec</option>
						</select>
					</div>
				</div>
			</div><br>
				<div class="input-field fifth-wrap inner-form">
					<button class="btn-search" type="submit" style="width:100%">SEARCH</button>
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
