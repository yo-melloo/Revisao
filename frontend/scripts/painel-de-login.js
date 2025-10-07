//painel-de-login.js
document.addEventListener('DOMContentLoaded', function() {
  const panel = document.querySelector('.login-panel');

  panel.addEventListener('click', function() {
    // Alterna a classe (ativa/desativa)
    panel.classList.toggle('is-active');
  });
});
