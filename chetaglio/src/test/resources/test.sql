INSERT INTO `citta` (`NOME`, `PROVINCIA`, `REGIONE`) VALUES ('Milano', 'MI', 'Lombardia');

INSERT INTO `categoria` (`DESCRIZIONE`, `NOME`) VALUES ('Taglio', 'Taglio');

INSERT INTO `negozi` (`COGNOME`, `CONTATORE`, `DESCRIZIONE`, `INDIRIZZO`, `INSEGNA`, `LATITUDINE`, `LONGITUDINE`, `MAIL`, `NOME`, `TELEFONO`, `id_citta`) VALUES ('Rossi', '0', 'Il negozio nasce a Milano nel 1970 dall\'idea di Francesco Rossi.', 'Via Ripamonti 106', 'Capelli Rossi', '100', '100', 'rancesco.rossi@yahoo.it', 'Francesco', '02 332210', '1');

INSERT INTO `immagini` (`URL`, `ID_NEGOZIO`) VALUES ('http://url', '1');

INSERT INTO `servizi` (`COSTO`, `DURATA`, `NOME`, `ID_CATEGORIA`, `ID_NEGOZIO`) VALUES ('100.20', '1 ora', 'Taglio lungo', '1', '1');

INSERT INTO `utenti` (`COGNOME`, `NOME`) VALUES ('Rossi', 'Fancesco');

INSERT INTO `commento` (`COMMENTO`, `ID_NEGOZIO`, `ID_UTENTE`) VALUES ('Bel taglio di capelli. Numero uno', '1', '1');

INSERT INTO `utenti` (`ACCOUNT_NON_BLOCCATO`, `ACCOUNT_NON_SCADUTO`, `CREDENZIALI_NON_SCADUTE`, `DISABILITATO`, `PASSWORD`, `USERNAME`) VALUES (true, true, true, false, 'admin', 'admin');

INSERT INTO `ruoli_utente` (`RUOLO`, `id_utente`) VALUES ('ADMIN', '2');


