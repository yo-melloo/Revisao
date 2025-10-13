document.addEventListener('DOMContentLoaded', function() {
  const form = document.getElementById('login-form');
  
  form.addEventListener('submit', async function(e) {
    e.preventDefault();

    const nameValue = form.name.value;
    const loginValue = form.login.value;
    const emailValue = form.email.value;
    const passwordValue = form.password.value;
    const passwordConfirmationValue = form['confirmar-senha'].value;

    // Validação básica
    if (passwordValue !== passwordConfirmationValue) {
      alert('As senhas não coincidem!');
      return;
    }

    // Objeto com os dados do novo usuário
    const novoUsuario = {
        name:nameValue,
	    password:passwordValue,
        login:loginValue,
        email:emailValue
    };

    try {
      const response = await fetch('https://glorious-funicular-jj594qxx977jcpjgq-8080.app.github.dev/api/auth/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(novoUsuario)
      });

      if (response.ok) {
        const data = await response.json();
        console.log('Usuário criado com sucesso:', data);
        alert('Usuário criado com sucesso!');
        window.location.href = '/login.html';
      } else {
        // Lê a mensagem de erro enviada pela API
        const errorText = await response.text();
        console.error('Erro ao criar usuário:', errorText);
        alert(`Erro: ${errorText}`);
      }
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  });
});
