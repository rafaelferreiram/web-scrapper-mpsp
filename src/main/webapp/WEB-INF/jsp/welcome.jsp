<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="author" content="colorlib.com">
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500"
	rel="stylesheet" />
<link href="css/main.css" rel="stylesheet" />
</head>
<body>
	<div class="s002">
		<form>
			<fieldset>
				<legend>SEARCH CPF / CNPJ</legend>
			</fieldset>
			<div class="inner-form">
				<div class="input-field first-wrap">
					<input id="search" type="text"
						placeholder="Insert CPF or CNPJ for a complete search" />
				</div>
				<div class="input-field fouth-wrap">
					<select data-trigger="" name="choices-single-defaul">
						<option placeholder="">CPF</option>
						<option>CNPJ</option>
					</select>
				</div>
				<div class="input-field fifth-wrap">
					<button class="btn-search" type="button">SEARCH</button>
				</div>
			</div>
		</form>
	</div>
	<script src="js/extention/choices.js"></script>
	<script src="js/extention/flatpickr.js"></script>
	<script>
      flatpickr(".datepicker",
      {});

    </script>
	<script>
      const choices = new Choices('[data-trigger]',
      {
        searchEnabled: false,
        itemSelectText: '',
      });

    </script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
