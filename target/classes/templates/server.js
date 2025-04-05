const express = require('express');
const http = require('http');
const WebSocket = require('ws');

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

app.use(express.static(__dirname + '/public')); // Serve frontend files

wss.on('connection', (ws) => {
    console.log("✅ Client Connected");

    ws.on('message', (message) => {
        console.log(`📩 Received: ${message}`);

        // Broadcast message to all clients
        wss.clients.forEach(client => {
            if (client.readyState === WebSocket.OPEN) {
                client.send(`🔔 Server: ${message}`);
            }
        });
    });

    ws.on('close', () => {
        console.log("🔴 Client Disconnected");
    });
});

// Start Server
server.listen(8080, () => {
    console.log("🚀 WebSocket Server running on http://localhost:8080/ws");
});
