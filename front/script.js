const formulario = document.querySelector("form")

const formNome = document.querySelector(".nome")
const formUserName = document.querySelector(".username")
const formEmail = document.querySelector(".email")
const formSenha = document.querySelector(".senha")
const formTel = document.querySelector(".tel")


function cadastrar() {
    fetch("http://localhost:8080/usuarios",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: formNome.value,
                username: formUserName.value,
                email: formEmail.value,
                senha: formSenha.value,
                telefone: formTel.value
            })

        })
        .then(function (res) {
            console.log(res)
        })
        .catch(function (res) {
            console.log(res)
        })


};

function limpar() {
    formNome.value = "";
    formUserName.value = "";
    formEmail.value = "";
    formSenha.value = "";
    formTel.value = "";
}


formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastrar();
    limpar();
});