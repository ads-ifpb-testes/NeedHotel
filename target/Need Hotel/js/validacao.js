
//----MÁSCARAS----//
$('#valorDiaria').mask('000000000.00', {reverse: true});

$('.numero').mask('000000000');

$('#cepImovel').mask('00000-000');

$('.words').mask('Z',{translation: {'Z': {pattern: /[a-zA-Z àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêî'ôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ-]/, recursive: true}}});

$('#cpf').mask('000.000.000-00', {reverse: true});

$('#telefone').mask('(00) 00000-0000');

function validaFormImovel(form) {
    var padrao = /^[0-9]{5}-[0-9]{3}$/;
    var cep = form.cepImovel.value

    if (!padrao.test(cep)){
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: 'CEP invalido',
        })
        return false;
    }
    return true;
}

function validaFormUsuario(form){
    var padraoCpf = /^\d{3}\.\d{3}\.\d{3}\-\d{2}$/;
    var padraoTel = /^\([1-9]{2}\) 9[1-9][0-9]{3}\-[0-9]{4}$/;

    var cpf = form.cpf.value;
    var tel = form.telefone.value;

    if(!padraoCpf.test(cpf)){
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: 'CPF invalido',
        })
        return false;
    }
    else if(!padraoTel.test(tel)) {
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: 'Telefone invalido',
        })
        return false;
    }

    return true;
}

function validaSenha(form) {
    var senha = form.senha.value;
    var conSenha = form.conSenha.value;

    if (senha != conSenha){
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: 'As senhas não correspondem',
        })
        return false;
    }
    return true;
}





