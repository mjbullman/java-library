#!/usr/bin/env bash

SESSION_NAME="MJBJavaLibrary"

command -v tmux >/dev/null || { echo "tmux not found"; exit 1; }

if tmux has-session -t "${SESSION_NAME}" 2>/dev/null; then
    echo "Attaching to existing session: ${SESSION_NAME}..."
    tmux attach -t "${SESSION_NAME}"
else
    echo "Creating new session: ${SESSION_NAME}..."

    # create new session and start nvim
    tmux new-session -d -s "${SESSION_NAME}" -n nvim nvim

    # split nvim window horizontally (top/bottom)
    tmux split-window -v -t "${SESSION_NAME}"

    # create new window and run claude code
    tmux new-window -t "${SESSION_NAME}" -n claude claude

    # create new window and run lazygit
    tmux new-window -t "${SESSION_NAME}" -n lazygit lazygit

    # focus nvim window
    tmux select-window -t "${SESSION_NAME}:nvim"

    # attach to session
    tmux attach -t "${SESSION_NAME}"
fi
