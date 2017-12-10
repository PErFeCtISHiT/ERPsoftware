set linesize 200
set term off verify off feedback off pagesize 999
set markup html on entmap ON spool on preformat off
spool g://test_tables.xls
@g://1.txt
spool off
exit