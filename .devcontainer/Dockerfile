FROM openjdk:25-jdk-bullseye

ARG USERNAME=vscode

# 開発用ユーザーを作成
RUN useradd -ms /bin/bash $USERNAME

# git をインストール
RUN apt-get update && apt-get install -y git
# vim をインストール
RUN apt-get update && apt-get install -y vim


# ユーザー .bashrc に alias とカスタムプロンプトを追加
RUN echo "\
git_branch_status() {\n\
  branch=\$(git rev-parse --abbrev-ref HEAD 2>/dev/null)\n\
  if [ ! -z \"\$branch\" ]; then\n\
    staged=\$(git diff --cached --name-only)\n\
    unstaged=\$(git diff --name-only)\n\
    if [ -n \"\$unstaged\" ]; then\n\
      icon=\"\\033[1;31m●\\033[0m\"\n\
    elif [ -n \"\$staged\" ]; then\n\
      icon=\"\\033[1;33m●\\033[0m\"\n\
    else\n\
      icon=\"\\033[1;32m●\\033[0m\"\n\
    fi\n\
    echo -e \"\$icon(\$branch)\"\n\
  fi\n\
}\n\
\n\
export PS1='\\033[1;34mvscode\\033[0m \\033[1;36m\\w\\033[0m \$(git_branch_status) \$ '\
" >> /home/$USERNAME/.bashrc


# デフォルトシェルを bash に設定
SHELL ["/bin/bash", "-c"]

USER $USERNAME
WORKDIR /workspace
