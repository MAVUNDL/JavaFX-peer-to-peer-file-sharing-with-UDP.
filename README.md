## Peer-to-Peer File Sharing System
Welcome to my Peer-to-Peer File Sharing System project. This project is inspired by popular peer-to-peer applications like BitTorrent and Direct Connect, where users can share files directly between peers without relying on a central server. In this project, I developed a system that allows a client to either send or receive files in two different modes: Seeder or Leecher.

## Project Overview
In this application, a client can operate in one of two modes: Seeder Mode or Leecher Mode. When the client starts, it prompts the user to select which mode they want to operate in. Based on the selection, the client can either share files (Seeder mode) or request and download files (Leecher mode) from another peer.

This system uses UDP (User Datagram Protocol) for communication, making it lightweight and suitable for fast data transfers. Below, I explain the functionality of both modes in more detail.

## Seeder Mode
In Seeder mode, the client is responsible for sharing files with other peers. Here's how it works:

- I have implemented a feature that allows the user to add files to a list of available files.
-  The user can choose files using a FileChooser and see them displayed in a list.
-  The Seeder can send a numbered list of available files to any peer that connects to it using the "LIST" command.
-  When a connected peer (Leecher) requests a specific file, the Seeder sends the requested file using the "FILE" command.

## Leecher Mode
In Leecher mode, the client connects to a Seeder to download files. Here's the functionality in this mode:

- The user enters the host address and port number of the Seeder to connect.
- I've used TextFields to capture this information, along with a Connect button.
- Once connected, the Leecher asks the Seeder for a list of available files.
- The Seeder responds with a numbered list of files using the "LIST" command, which is displayed in a list format.
- The user selects a file from the list and requests it from the Seeder by sending the file number using the "FILE" command.
- A Retrieve button facilitates this process.
- The selected file is then received from the Seeder and saved locally on the Leecher's machine.

## How to Run the Project
- Start the client, and you will be prompted to select a mode (Seeder or Leecher).
- If you're in Seeder mode, add files to the list of available files and wait for peers to connect.
- In Leecher mode, connect to a Seeder using the host address and port, view the list of available files, and request the desired file.

## Future Improvements
I plan to enhance this system by adding features like file integrity checks and more robust error handling.
