SELECT users.i0d, users.username, users.user_role, accounts.id AS account_id, accounts.balance, accounts.active,
FROM users
LEFT JOIN users_accounts_jt ON users.id = users_accounts_jt.acc_owner
LEFT JOIN accounts ON accounts.id = users_accounts_jt.account;