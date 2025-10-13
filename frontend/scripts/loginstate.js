//loginstate.js
function setLoginState(state) {
  const panel = document.querySelector('.login-panel');
  panel.classList.remove('status--error', 'status--success');
  if (state === 'error') {
    panel.classList.add('status--error');
  } else if (state === 'success') {
    panel.classList.add('status--success');
  }
}

function showStatusMessage(msgText, color = "red") {
  const statusMessage = document.getElementById('status-message');
  if (!statusMessage) return;
  statusMessage.textContent = msgText || "";
  statusMessage.style.color = color;
  statusMessage.classList.add('show');
}

function hideStatusMessage() {
  const statusMessage = document.getElementById('status-message');
  if (!statusMessage) return;
  statusMessage.classList.remove('show');
  setTimeout(() => {
    statusMessage.textContent = "";
    statusMessage.style.color = "";
  }, 400);
}

// Função fetch com timeout
async function fetchWithTimeout(resource, options = {}, timeout = 5000) {
  const controller = new AbortController();
  const id = setTimeout(() => controller.abort(), timeout);
  options.signal = controller.signal;

  try {
    const response = await fetch(resource, options);
    clearTimeout(id);
    return response;
  } catch (error) {
    clearTimeout(id);
    // Detecção específica de timeout
    if (error.name === 'AbortError') {
      throw new Error('Erro de Timeout: estamos possivelmente fora do ar, pedimos desculpas.');
    }
    // Erro genérico de conexão/fetch
    throw new Error('Não foi possível estabelecer uma conexão com o servidor. Tente novamente mais tarde.');
  }
}

hideStatusMessage();