async function login(login, password) {
  try {
    const resp = await fetch("https://glorious-funicular-jj594qxx977jcpjgq-8080.app.github.dev/api/auth/login", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({login, password})
    });

    if (resp.status === 403) {
      alert("Usuário ou senha inválidos!");
      return;
    }

    const data = await resp.json();
    
    if (resp.ok && data.token) {
      // Login sucesso
      alert("Login realizado com sucesso!");
      // Armazena o token no localStorage
      localStorage.setItem('token', data.token);
      // Redireciona para a página principal após 1 segundo
      setTimeout(() => {
        window.location.href = '/frontend/index.html';
      }, 1000);
    } else {
      // Erro no login
      alert(data.message || "Usuário ou senha inválidos!");
    }
  } catch (err) {
    console.error(err);
    alert("Erro de conexão com o servidor.");
  }
}

function showAlert(message, type) {
  const alertClass = type === 'success' ? 'alert-success' : 'alert-error';
  const alertDiv = document.createElement('div');
  alertDiv.className = `alert ${alertClass}`;
  alertDiv.textContent = message;
  
  // Remove alertas anteriores
  const existingAlerts = document.querySelectorAll('.alert');
  existingAlerts.forEach(alert => alert.remove());
  
  // Adiciona o novo alerta no topo da página
  document.body.insertBefore(alertDiv, document.body.firstChild);
  
  // Remove o alerta após 3 segundos
  setTimeout(() => {
    alertDiv.remove();
  }, 3000);
}