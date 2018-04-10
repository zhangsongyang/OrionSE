#!/usr/bin/python
# -*- coding: UTF-8 -*-

import MySQLdb
import requests
import json


def main(configuration):
    # connect
    conn = MySQLdb.connect(host="127.0.0.1", user="root", passwd="root", db="hibernate01", charset="utf8", port=3306)
    # conn = MySQLdb.connect(host="emuplus-db.uhome.haier.net", user="emuplus", passwd="emuplus123", db="emuplus",
    #                        charset="utf8", port=3306)
    cursor = conn.cursor()

    file = open(configuration, 'r')
    for line in file:
        try:
            request_url_f = line.find('Request URI:')
            request_url = ''
            if request_url_f != -1:
                request_url_e = line.find(',sequenceId:')
                request_url = line[request_url_f + 12:request_url_e]
                print "Request_URI:" + request_url

            appid_f = line.find('appid=')
            appid = ''
            if appid_f != -1:
                appid_e = line[appid_f:].find(';')
                appid = line[appid_f + 6:appid_f + appid_e]
                print "appid=" + appid

            request_time = line[0:19]
            print "Request_time:" + request_time

            request_costs_f = line.find('Current request costs :')
            request_costs = ''
            if request_costs_f != -1:
                request_costs_e = line.find(' ms.')
                request_costs = line[request_costs_f + 23:request_costs_e]
                print "request costs:" + request_costs

            clientid_f = line.find('clientid=')
            clientid = ''
            if clientid_f != -1:
                clientid_e = line[clientid_f:].find(';')
                clientid = line[clientid_f + 9:clientid_f + clientid_e]
                print "clientid:" + clientid

            appversion_f = line.find('appversion=')
            appversion = ''
            if appversion_f != -1:
                appversion_e = line[appversion_f:].find(';')
                appversion = line[appversion_f + 11:appversion_f + appversion_e]
                if appversion.find('&') != -1:
                    appversion = appversion[:appversion.find('&')]
                print "appversion:" + appversion

            request_ip_f = line.find('cdn-src-ip=')
            request_ip = ''
            if request_ip_f != -1:
                request_ip_e = line[request_ip_f:].find(';')
                request_ip = line[request_ip_f + 11:request_ip_f + request_ip_e]
                print "request_ip:" + request_ip
                ak = "RW3d0xHYyW0QuchLEGvswGCtbsEL1rkK"
                r = requests.get('https://api.map.baidu.com/location/ip?ip=%s&ak=%s&coor=bd09ll' % (request_ip, ak))
                # r.encoding = "utf-8"
                data = r.json()
                if data['status'] == 0:
                    # print json.dumps(data, indent=4, sort_keys=True, ensure_ascii=False)
                    province = data['content']['address_detail']['province']
                    city = data['content']['address_detail']['city']
                    longitude = data['content']['point']['x']
                    dimension = data['content']['point']['y']
                    print province
                    print city
                    print longitude
                    print dimension

            # add
            sql = "insert into omsdm_api_request_record(project, request_uri, app_id, app_version, client_id, request_ip, " \
                  "request_time, request_costs, province, city, longitude, dimension, create_time, update_time) " \
                  "values(%s, %s, %s, %s, %s, %s, str_to_date(%s, '%%Y-%%m-%%d %%H:%%i:%%s'), %s, %s, %s, %s, %s, now(), now())"
            param = (
                "emuplus", request_url, appid, appversion, clientid, request_ip, request_time, request_costs, province,
                city,
                longitude, dimension)
            n = cursor.execute(sql, param)
            print n
            conn.commit()
        except Exception, e:
            print e

    file.close()
    cursor.close()
    # 关闭
    conn.close()


main("D:\code\python\local\doc\string.txt")