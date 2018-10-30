import blservice.BillService;
import blservice.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;


/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger("Main");

    private static final PlanService planService = new PlanService();

    private static final BillService billService = new BillService();


    /**
     * 测试前请修改resources文件夹中的 mybatis-config 配置文件，将 url,
     * username, password 修改成本地的 url, username, password
     * 项目使用 java 11 编写，请使用 java 11 编译器进行编译
     */
    public static void main(String[] args) {
        Instant start = Instant.now();

        // unsubscribe a plan and the plan will lose efficacy next month
//        planService.unsubscribeNextMonth(10, "11111111111");

        // unsubscribe a plan immediately
//        planService.unsubscribeInTime(10, "11111111111");

        // subscribe a plan immediately
//        planService.subscribeInTime(10, "11111111111");

        // subscribe a plan and the plan will be effective next month
//        planService.subscribeNextMonth(12, "11111111111");

        // show all history orders information
//        planService.orderInformation("11111111111");

        // show currently effective plans, including effective plan
        // and the plan which has been unsubscribed next month
        planService.effectivePlans("11111111111");

        // generate the user's bill for the month
//        billService.showMonthBill("11111111111");

        // generate the user's call bill for the month
//        billService.showCallBills(2, "11111111111");

        // generate the user's data bill for the month
//        billService.showDataBills(2, "11111111111");
        Instant end = Instant.now();
        System.out.println("spend time is " + Duration.between(start, end).toMillis() + " ms");

//        commandLine();
    }

    private static void commandLine() {
        // Show help information first
        help();
        System.out.println();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String currUser = inputPhoneNumber(reader);
            System.out.print("> ");
            String line = reader.readLine();
            while (!line.equals("exit")) {
                switch (line) {
                    case "cp":
                        planService.effectivePlans(currUser);
                        break;
                    case "cu":
                        currUser = inputPhoneNumber(reader);
                        break;
                    case "history":
                        planService.orderInformation(currUser);
                        break;
                    case "subscribe":
                        subscribe(currUser, reader);
                        break;
                    case "help":
                        help();
                        break;
                    case "list":
                        planService.listAvailablePackages();
                        break;
                    case "unsubscribe":
                        unsubscribe(currUser, reader);
                        break;
                    case "cf":
                        callFee(currUser, reader);
                        break;
                    case "df":
                        dataFee(currUser, reader);
                        break;
                    case "bill":
                        billService.showMonthBill(currUser);
                        break;
                }

                System.out.print("> ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void callFee(String currUser, BufferedReader reader) throws IOException {
        System.out.print("请输入希望查询的月份范围：");
        int months = Integer.parseInt(reader.readLine());

        if (months <= 1) {
            System.out.println("输入必须大于等于1");
            return;
        }

        billService.showCallBills(months, currUser);
    }

    private static void dataFee(String currUser, BufferedReader reader) throws IOException {
        System.out.print("请输入希望查询的月份范围：");
        int months = Integer.parseInt(reader.readLine());

        if (months <= 1) {
            System.out.println("输入必须大于等于1");
            return;
        }

        billService.showDataBills(months, currUser);
    }

    private static void unsubscribe(String currUser, BufferedReader reader) throws IOException {
        System.out.print("请输入需要取消的套餐编号");
        int planId = Integer.parseInt(reader.readLine());

        System.out.println("是否需要立即生效？ y/n");
        String immediate = reader.readLine();

        if (immediate.equalsIgnoreCase("y")) {
            planService.unsubscribeInTime(planId, currUser);
        } else if (immediate.equalsIgnoreCase("n")) {
            planService.unsubscribeNextMonth(planId, currUser);
        } else {
            System.out.println("输入错误");
        }
    }

    private static void subscribe(String currUser, BufferedReader reader) throws IOException {
        System.out.println("当前能够订购的套餐有");
        planService.listAvailablePackages();

        System.out.print("请输入想要订购的套餐号");
        int planId = Integer.parseInt(reader.readLine());

        System.out.println("是否需要立即生效？ y/n");
        String immediate = reader.readLine();

        if (immediate.equalsIgnoreCase("y")) {
            planService.subscribeInTime(planId, currUser);
        } else if (immediate.equalsIgnoreCase("n")) {
            planService.subscribeNextMonth(planId, currUser);
        } else {
            System.out.println("输入错误");
        }
    }

    private static String inputPhoneNumber(BufferedReader reader) throws IOException {
        String phoneNumber;

        do {
            System.out.print("请输入手机号：");
            phoneNumber = reader.readLine();
        } while (planService.userNotExists(phoneNumber));

        return phoneNumber;
    }

    private static void help() {
        System.out.println("===============支持命令==============");
        String format = "%-20s %s\n";
        System.out.printf(format, "cp", "获得当前套餐信息使用情况");
        System.out.printf(format, "list", "查看所有可订购套餐");
        System.out.printf(format, "history", "获得套餐订购历史记录");
        System.out.printf(format, "subscribe", "订购套餐");
        System.out.printf(format, "unsubscribe", "退订套餐");
        System.out.printf(format, "cf", "查询通话资费");
        System.out.printf(format, "df", "查询流量资费");
        System.out.printf(format, "bill", "生成该月账单");
        System.out.printf(format, "exit", "退出");
        System.out.printf(format, "cu", "切换账户");
        System.out.println("====================================");
    }
}
