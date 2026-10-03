# MineGram [![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
Simple Paper-plugin for connection of chat in game with chat in telegram.
## Features
  Copies messages from server-chat to chat in Telegram and back.
  
  Sends in Telegram messages about server starup/showdown, and players joining, leaving or dying.
  
  Now it only works with supergroups (it will be updated soon).
## Installation
1. Create new Telegram-bot via @BotFather and save the token of new bot.
2. Set privacy mode to DISABLED.
3. Add bot to your supergroup. If you added bot before disabling privacy mode, remove it and add again.
4. Add any command to the bot and execute it thread where you want it to send messages from server-chat.
5. Open the https://api.telegram.org/bot<token>/getUpdates to get the id of supergroup and thread.
6. Download the plugin on your server and setup the config.yml
```YAML
  //# Token of your telegram-bot. You can get it in @BotFather in telegram.
  token: "123456789:ABCdefGHIJKLMNOPRS"

  //# Unique id of your telegram-chat. You can get it on https://api.telegram.org/bot<token>/getUpdates.
  chat_id: "-123456789"

  //# Id of thread in supergroup.
  thread_id: 1
```
## Planned features
  -Add messages.yml and localize plugin for other languages.  
  -Make this plugin works with the default groups and channels.  
  -Add MarkdownV2 and MiniMessage support.  
  -Add Chatty plugin support.

# License
Apache 2.0

```
Copyright 2026 mih4rt

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


