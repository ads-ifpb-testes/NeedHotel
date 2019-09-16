$(document).ready(function(){
    $('.modal').modal({
        preventScrolling: true
    });
});

var data = new Date();

$(document).ready(function(){
    $('.datepicker').datepicker({
        i18n: {
            cancel: 'Cancelar',
            clear: 'Limpar',
            done: 'Ok',
            months: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            monthsShort: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
            weekdays: ["Domingo","Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"],
            weekdaysShort: ["Dom","Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"],
            weekdaysAbbrev: ["DOM","SEG", "TER", "QUA", "QUI", "SEX", "SÁB"],

        },

        format: 'dd/mm/yyyy',
        maxDate: new Date(),
    });
});






