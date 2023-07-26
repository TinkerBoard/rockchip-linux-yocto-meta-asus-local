#!/bin/sh

PATH="/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin"

case "$1" in
	start)
		echo "Starting LTE init"
		/etc/modem/mm_cli start &
		if asus_cmcli keepalive status; then
			/etc/mm/mm_keepalive run &
		fi
		echo "."
		;;
	stop)
		echo "Stoping LTE init"
		/etc/modem/mm_cli stop &
		/etc/mm/mm_keepalive stop &
		echo "."
		;;
	restart|reload)
		;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
esac

exit 0
