//login.js

// Testando no neovim

document.addEventListener('DOMContentLoaded', function() {
  const form = document.getElementById('login-form');
  form.addEventListener('submit', async function(e) {
    e.preventDefault();
    hideStatusMessage();
    setLoginState(null);

    const loginValue = form.login.value;
    const passwordValue = form.password.value;

    try {
      const resp = await fetchWithTimeout(
        (window.ENV.API_BASE_URL + "/auth/login"),
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ login: loginValue, password: passwordValue })
        },
        5000 // timeout de 5s
      );

      let data = {};
      const contentType = resp.headers.get('content-type') || '';
      if (contentType.includes('application/json')) {
        data = await resp.json();
      }

      if (resp.ok && data.token) {
        setLoginState("success");
        showStatusMessage("Login bem-sucedido!", "green");
        localStorage.setItem("token", data.token);
        setTimeout(() => {
          window.location.href = "profile.html";
        }, 700);
        return data;
      } else {
        setLoginState("error");
        if (resp.status === 403) {
          showStatusMessage("Acesso negado. Verifique suas credenciais.", "red");
          throw new Error("Acesso negado. Verifique suas credenciais.");
        } else if (resp.status === 401) {
          showStatusMessage("Deu red aquikkkkk", "red");
          throw new Error("Acesso negado. Verifique suas credenciais.");
        } else {
          showStatusMessage(data.message || "Usuário ou senha inválidos!", "red");
          throw new Error(data.message || "Usuário ou senha inválidos!");
        }
      }
    } catch (err) {
      setLoginState("error");
      showStatusMessage(err.message || "Erro inesperado!", "red");
      // O throw pode ser omitido se não quiser "propagar" para o console
    }
  });



});
