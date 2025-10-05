async function login(login, password) {
  try {
    const resp = await fetch("https://glorious-funicular-jj594qxx977jcpjgq-8080.app.github.dev/api/auth/login", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({login, password})
    });

    if (resp.status === 403) {
      console.log("Usuário ou senha inválidos!");
      setLoginState('error');
      return;
    }

    const data = await resp.json();
    
    if (resp.ok && data.token) {
      // Login sucesso
      console.log("Login realizado com sucesso!");
      // Armazena o token no localStorage
      localStorage.setItem('token', data.token);
      setLoginState('success');
      // Redireciona para a página principal após 1 segundo
      setTimeout(() => {
        window.location.href = '/frontend/index.html';
      }, 1000);
    } else {
      // Erro no login
      console.log(data.message || "Usuário ou senha inválidos!");
      setLoginState('error');
    }
  } catch (err) {
    console.error(err);
    console.log("Erro de conexão com o servidor.");
  }
}